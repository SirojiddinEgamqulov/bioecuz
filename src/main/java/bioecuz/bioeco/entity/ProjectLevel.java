package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.template.NameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProjectLevel extends NameEntity {
    @Column(nullable = false)
    private Integer number;
    @ManyToOne(optional = false)
    private Project project;
}