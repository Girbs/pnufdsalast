package fdsa.edu.pnu.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id

    private int idRole;
    private String roleName;
    private String roleDescription;
    @ManyToMany(targetEntity = Utilisateur.class, fetch = FetchType.EAGER, mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Utilisateur> utlilisateurs;

}
