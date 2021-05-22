package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Blog;
import bioecuz.bioeco.entity.Project;
import bioecuz.bioeco.entity.ProjectLevel;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.UUID;

@Projection(types = Project.class)
public interface ProjectProjection {
    UUID getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();
    boolean isActive();
    String getTextUz();
    String getTextRu();
    String getTextEn();
    Integer getActiveLevel();
    List<ProjectLevelProjection> getSteps();
}
