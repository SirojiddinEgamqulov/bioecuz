package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.Home;
import bioecuz.bioeco.projection.HomeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "home", collectionResourceRel = "list", excerptProjection = HomeProjection.class)
public interface HomeRepository extends JpaRepository<Home, UUID> {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Home> S save(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void delete(Home home);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll();

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends Home> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Home> List<S> saveAll(Iterable<S> iterable);
}
