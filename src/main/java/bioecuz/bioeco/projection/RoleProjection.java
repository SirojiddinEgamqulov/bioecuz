package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Role;
import bioecuz.bioeco.entity.enums.RoleName;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Role.class)
public interface RoleProjection {
    Integer getId();
    RoleName getRoleName();
}
