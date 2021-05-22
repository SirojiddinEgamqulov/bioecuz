package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.Role;
import bioecuz.bioeco.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Set<Role> findAllByRoleName(RoleName roleName);
}