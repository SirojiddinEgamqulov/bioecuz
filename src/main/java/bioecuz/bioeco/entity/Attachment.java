package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.enums.AttachmentType;
import bioecuz.bioeco.entity.template.UuidEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends UuidEntity {
    @Column(nullable = false)
    private String name;

    private String originalName;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private String contentType;

    @Enumerated(EnumType.STRING)
    private AttachmentType attachmentType;
}
