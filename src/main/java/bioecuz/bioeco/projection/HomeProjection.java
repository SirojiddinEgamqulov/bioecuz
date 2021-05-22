package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Home;
import org.springframework.data.rest.core.config.Projection;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Projection(types = Home.class)
public interface HomeProjection {
    UUID getId();
    Set<String> getSlide();
    Map<String, String> getFooter();
    Map<String, String> getCollection();
}
