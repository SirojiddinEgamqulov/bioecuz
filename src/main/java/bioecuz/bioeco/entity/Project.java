package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.template.NameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project extends NameEntity {

    private String textUz;
    private String textRu;
    private String textEn;

    private Integer activeLevel;

    @OneToMany(mappedBy = "project")
    private List<ProjectLevel> steps;
}
