package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.ProjectLevel;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = ProjectLevel.class)
public interface ProjectLevelProjection {
    UUID getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();
    boolean isActive();
    Integer getNumber();
}
