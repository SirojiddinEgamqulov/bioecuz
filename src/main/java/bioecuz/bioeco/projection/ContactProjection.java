package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Contact;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.UUID;

@Projection(types = Contact.class)
public interface ContactProjection {
    UUID getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();
    boolean isActive();
    String getTextUz();
    String getTextRu();
    String getTextEn();
    AttachmentProjection getAttachment();
}
