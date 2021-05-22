package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Blog;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.UUID;

@Projection(types = Blog.class)
public interface BlogProjection {
    UUID getId();
    String getTitleUz();
    String getTitleRu();
    String getTitleEn();
    String getTextUz();
    String getTextRu();
    String getTextEn();
    Timestamp getPublishedTime();
    AttachmentProjection getAttachment();
}
