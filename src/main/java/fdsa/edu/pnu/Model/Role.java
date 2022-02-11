package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
@Setter
@Getter
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable {

    @Id
    private Integer id;
    private String roleName;
    private String roleDescription;

    @ManyToMany( targetEntity = Utilisateur.class , mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("role")
    private Set<Utilisateur> utlilisateurs;




    @ManyToMany( targetEntity = Permission.class ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("roles")
    private Set<Permission> permission;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "PermissionRole",
//            joinColumns = {
//                    @JoinColumn(name = "RoleId")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "PermissionId")
//            })
//   private Set<Permission> permission;







}
