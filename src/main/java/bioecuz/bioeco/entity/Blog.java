package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.template.UuidEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Blog extends UuidEntity {

    @Column(nullable = false)
    private String titleUz;
    @Column(nullable = false)
    private String titleRu;
    @Column(nullable = false)
    private String titleEn;

    @Column(columnDefinition = "text", nullable = false)
    private String textUz;

    @Column(columnDefinition = "text", nullable = false)
    private String textRu;

    @Column(columnDefinition = "text", nullable = false)
    private String textEn;

    @Column(nullable = false)
    private Timestamp publishedTime;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;
}
