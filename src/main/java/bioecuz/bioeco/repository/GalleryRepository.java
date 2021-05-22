package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.Gallery;
import bioecuz.bioeco.projection.GalleryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "gallery", collectionResourceRel = "list", excerptProjection = GalleryProjection.class)
public interface GalleryRepository extends JpaRepository<Gallery, UUID> {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Gallery> S save(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void delete(Gallery gallery);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll();

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends Gallery> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Gallery> List<S> saveAll(Iterable<S> iterable);
}
