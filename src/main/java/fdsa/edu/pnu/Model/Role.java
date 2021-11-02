package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable {

    @Id
    private Integer id;
    private String roleName;
    private String roleDescription;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Utilisateur.class, mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Utilisateur> utlilisateurs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }


    @JsonBackReference
    public Set<Utilisateur> getUtlilisateurs() {
        return utlilisateurs;
    }

    public void setUtlilisateurs(Set<Utilisateur> utlilisateurs) {
        this.utlilisateurs = utlilisateurs;
    }
}
