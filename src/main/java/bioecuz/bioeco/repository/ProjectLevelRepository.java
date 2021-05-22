package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.ProjectLevel;
import bioecuz.bioeco.projection.ProjectLevelProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "projectLevel",collectionResourceRel = "list", excerptProjection = ProjectLevelProjection.class)
public interface ProjectLevelRepository extends JpaRepository<ProjectLevel, UUID> {
}