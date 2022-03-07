/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 */
/**
 * Licensee:
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)

@PrimaryKeyJoinColumn(name = "PersonneID", referencedColumnName = "ID")

public class Utilisateur extends Personne implements Serializable {


    @Column(name = "Status")
    private boolean status;

    @Column(name = "Username")
    private String userName;

    @Column(name = "Password")
    private String userPassword;

    @Column(name = "derniereConnexion", nullable = true)
    private Date derniereConnexion;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("utlilisateurs")
    private Set<Role> role;

}
