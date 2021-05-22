package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.Attachment;
import bioecuz.bioeco.entity.enums.AttachmentType;
import bioecuz.bioeco.projection.AttachmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "attachment", collectionResourceRel = "list", excerptProjection = AttachmentProjection.class)
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    List<Attachment> findAllIdByAttachmentType(AttachmentType attachmentType);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Attachment> S save(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Attachment> List<S> saveAll(Iterable<S> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void delete(Attachment attachment);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends Attachment> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll();
}
