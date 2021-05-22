package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Projection(types = User.class)
public interface UserProjection {
    UUID getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPhoneNumber();
    RoleProjection[] getRoles();
    boolean isEnabled();
}
