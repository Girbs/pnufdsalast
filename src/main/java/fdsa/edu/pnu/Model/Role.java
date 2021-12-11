package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Role")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable {

    @Id
    private Integer id;
    private String roleName;
    private String roleDescription;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Utilisateur.class, mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Utilisateur> utlilisateurs;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PermissionRole",
            joinColumns = {
                    @JoinColumn(name = "RoleId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PermissionId")
            })
    private Set<Permission> permission;


//    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Permission.class, mappedBy = "roles", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    private Set<Permission> permission;

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
