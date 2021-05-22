package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Attachment;
import bioecuz.bioeco.entity.enums.AttachmentType;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = Attachment.class)
public interface AttachmentProjection {
    UUID getId();
    String getName();
    String getOriginalName();
    long getSize();
    String getContentType();
    AttachmentType getAttachmentType();
}
