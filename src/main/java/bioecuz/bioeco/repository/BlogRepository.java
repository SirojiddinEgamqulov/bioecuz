package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.Blog;
import bioecuz.bioeco.entity.User;
import bioecuz.bioeco.projection.BlogProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "blog", collectionResourceRel = "list", excerptProjection = BlogProjection.class)
public interface BlogRepository extends JpaRepository<Blog, UUID> {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void delete(Blog blog);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends Blog> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Blog> List<S> saveAll(Iterable<S> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll();

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    <S extends Blog> S save(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @Override
    void deleteById(UUID uuid);

    @Override
    List<Blog> findAll(Sort sort);

    @Query(nativeQuery = true, value = "select * from blog where published_time>=")
    Page<Blog> findAllByPublishedTimeBefore(Pageable pageable);
}