package bioecuz.bioeco.service;

import bioecuz.bioeco.entity.Attachment;
import bioecuz.bioeco.entity.AttachmentContent;
import bioecuz.bioeco.entity.enums.AttachmentType;
import bioecuz.bioeco.repository.AttachmentContentRepository;
import bioecuz.bioeco.repository.AttachmentRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

@Service
public class AttachmentService {
    final
    AttachmentRepository attachmentRepository;

    final
    AttachmentContentRepository attachmentContentRepository;

    @Autowired
    public AttachmentService(AttachmentRepository attachmentRepository, AttachmentContentRepository attachmentContentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentRepository = attachmentContentRepository;
    }

    public String uploadFile(MultipartHttpServletRequest request) {
        try {
            Iterator<String> fileNames = request.getFileNames();
            while (fileNames.hasNext()) {
                MultipartFile file = request.getFile(fileNames.next());
                assert file != null;
                Attachment attachment = new Attachment();
                Attachment saveToFolder = saveToFolder(
                        Objects.requireNonNull(file.getOriginalFilename()),
                        file.getContentType(),
                        file.getInputStream(),
                        attachment,
                        file.getSize()
                );
                return saveToFolder.getId().toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpEntity<?> getFile(UUID id) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getAttachment"));
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(id);
        return ResponseEntity.ok().contentType(MediaType.valueOf(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + attachment.getName() + "\"")
                .body(attachmentContent.getContent());
    }

    public void deleteAttachment(UUID id) {
        attachmentContentRepository.deleteByAttachment_Id(id);
        attachmentRepository.deleteById(id);
    }

    public String uploadDir = "uploads";

    public Attachment saveToFolder(String originalName, String contentType, InputStream inputStream, Attachment image, long size) throws IOException {
        String name = UUID.randomUUID().toString() + "." +
                originalName.split("\\.")
                        [originalName.split("\\.").length - 1];

        byte[] bufferedBytes = new byte[1024];
        File file2 = new File(uploadDir);
        file2.mkdir();//todo mkdir chek nima ekanini aniqlash

        File file = new File(file2, name);
        FileOutputStream outStream;
        int count;

        BufferedInputStream fileInputStream = new BufferedInputStream(inputStream);
        outStream = new FileOutputStream(file);
        while ((count = fileInputStream.read(bufferedBytes)) != -1) {
            outStream.write(bufferedBytes, 0, count);
        }
        outStream.close();
        if (file.exists()) {
            image.setName(name);
            image.setOriginalName(originalName);
            image.setSize(size);
            image.setContentType(contentType);
            return attachmentRepository.save(image);
        } else return null;
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public HttpEntity<?> getFile(HttpServletResponse response, UUID id) throws IOException {
        Attachment attachment = attachmentRepository.getOne(id);

        if (attachment.getOriginalName() == null) {
            return getFile(attachment.getId());
        } else {
            response.setContentType(attachment.getContentType());
            response.setContentLength((int) attachment.getSize());
            response.setHeader("Cache-Control", "max-age=8640000");
            response.setHeader("Content-disposition", "attachment; filename=\"" + attachment.getOriginalName() + "\"");

            File file = new File(uploadDir + "/" + attachment.getName());
            InputStream in = new FileInputStream(file);
            return ResponseEntity.ok(FileCopyUtils.copy(in, response.getOutputStream()));
        }
    }
}
