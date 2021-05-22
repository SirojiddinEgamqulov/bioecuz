package bioecuz.bioeco.repository;

import bioecuz.bioeco.entity.Blog;
import bioecuz.bioeco.projection.BlogProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "blog",collectionResourceRel = "list", excerptProjection = BlogProjection.class)
public interface ProjectRepository extends JpaRepository<Blog, UUID> {
}