package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "Persmission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PERSONNE_ID_GENERATOR", strategy = "native")
    private Integer id;
    private String nomPermission;
    private String descriptionPermission;
    //@ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class, mappedBy = "permission", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //private Set<Role> roles;

    @ManyToMany(targetEntity = Role.class, mappedBy = "permission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("permission")
    private Set<Role> roles;
}
