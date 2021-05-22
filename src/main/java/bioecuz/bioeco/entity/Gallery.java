package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.template.NameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Gallery extends NameEntity {
    private String youTubeId;
    @OneToOne
    private Attachment attachment;
}
