package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name = "Persmission")
public class Permission {

    @Id
    private Integer id;
    private String nomPermission;
    private String descriptionPermission;
//    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class, mappedBy = "permission", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    private Set<Role> roles;
}
