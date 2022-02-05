/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */
/**
 * Licensee:
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity


//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorValue("Utilisateur")
@PrimaryKeyJoinColumn(name = "PersonneID", referencedColumnName = "ID")

public class Utilisateur extends Personne implements Serializable {


    @Column(name = "Status")
    private boolean status;

    @Column(name = "Username")
    private String userName;

    @Column(name = "Password")
    private String userPassword;



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            })
    @JsonManagedReference(value = "user-role")
    private Set<Role> role;
    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the roles
     */
    public Set<Role> getRoles() {
        return role;
    }


    public void setRoles(Set<Role> role) {
        this.role = role;
    }

}
