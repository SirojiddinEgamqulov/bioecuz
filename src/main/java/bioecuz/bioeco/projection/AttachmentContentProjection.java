package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.AttachmentContent;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = AttachmentContent.class)
public interface AttachmentContentProjection {
    UUID getId();
    AttachmentProjection getAttachment();
    byte[] getContent();
    String getStringContent();
}
