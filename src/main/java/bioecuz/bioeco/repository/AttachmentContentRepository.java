package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.AttachmentContent;
import bioecuz.bioeco.projection.AttachmentContentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "attachmentContent", collectionResourceRel = "list", excerptProjection = AttachmentContentProjection.class)
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    void deleteByAttachment_Id(UUID id);

    AttachmentContent findByAttachmentId(UUID id);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends AttachmentContent> List<S> saveAll(Iterable<S> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends AttachmentContent> S save(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void delete(AttachmentContent attachmentContent);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends AttachmentContent> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll();
}
