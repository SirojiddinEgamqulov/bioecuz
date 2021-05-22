package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.template.NameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact extends NameEntity {

    @Column(columnDefinition = "text", nullable = false)
    private String textUz;

    @Column(columnDefinition = "text", nullable = false)
    private String textRu;

    @Column(columnDefinition = "text", nullable = false)
    private String textEn;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;
}
