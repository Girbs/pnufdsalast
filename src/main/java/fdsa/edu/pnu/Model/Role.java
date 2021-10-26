package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int idRole;
    @Id
    private Integer id;
    private String roleName;
    private String roleDescription;
    @ManyToMany(fetch =FetchType.EAGER,targetEntity = Utilisateur.class, mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Utilisateur> utlilisateurs;

}
