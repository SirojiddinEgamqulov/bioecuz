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

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent extends UuidEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

    @Column(nullable = false)
    private byte[] content;

    @Column(columnDefinition = "text")
    private String stringContent;

    public AttachmentContent(Attachment attachment, byte[] content) {
        this.attachment = attachment;
        this.content = content;
    }
}
