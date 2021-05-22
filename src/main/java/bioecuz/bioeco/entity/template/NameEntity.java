package bioecuz.bioeco.entity.template;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class NameEntity extends UuidEntity{
    private String nameUz;
    private String nameRu;
    private String nameEn;

    private boolean active;
}
