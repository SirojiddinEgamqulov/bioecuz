package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.User;
import bioecuz.bioeco.projection.UserProjection;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("*")
@RepositoryRestResource(path = "user", collectionResourceRel = "list", excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String username);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> S save(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    boolean existsById(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    List<User> findAll();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    List<User> findAll(Sort sort);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    List<User> findAllById(Iterable<UUID> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> List<S> saveAll(Iterable<S> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void flush();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> S saveAndFlush(S s);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void deleteInBatch(Iterable<User> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void deleteAllInBatch();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    User getOne(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> List<S> findAll(Example<S> example);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> List<S> findAll(Example<S> example, Sort sort);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    Page<User> findAll(Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> Optional<S> findOne(Example<S> example);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> Page<S> findAll(Example<S> example, Pageable pageable);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> long count(Example<S> example);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    <S extends User> boolean exists(Example<S> example);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    long count();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void deleteById(UUID uuid);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void delete(User user);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll(Iterable<? extends User> iterable);

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @Override
    void deleteAll();
}