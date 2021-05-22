package bioecuz.bioeco.entity;

import bioecuz.bioeco.entity.template.UuidEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Home extends UuidEntity {

    @ElementCollection
    private Set<String> slide;

    @ElementCollection
    private Map<String, String> footer;

    @ElementCollection
    private Map<String, String> collection;
}
