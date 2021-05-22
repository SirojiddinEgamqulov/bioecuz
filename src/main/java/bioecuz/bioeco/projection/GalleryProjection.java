package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Gallery;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = Gallery.class)
public interface GalleryProjection {
    UUID getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();
    boolean isActive();
    String getYouTubeId();
    AttachmentProjection getAttachment();
}
