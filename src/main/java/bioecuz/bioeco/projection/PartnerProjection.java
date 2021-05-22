package bioecuz.bioeco.projection;

import bioecuz.bioeco.entity.Partner;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = Partner.class)
public interface PartnerProjection {
    UUID getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();
    String getLink();
    boolean isActive();
    AttachmentProjection getLogo();
}