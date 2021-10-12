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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Personnel")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Personnel")
public class Personnel extends fdsa.edu.pnu.Model.Utilisateur implements Serializable {
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Fonction.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "FonctionID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "FKPersonnel768785"))
    private fdsa.edu.pnu.Model.Fonction fonctionpersonel;

    public Personnel() {
    }

    public fdsa.edu.pnu.Model.Fonction getFonctionpersonel() {
        return fonctionpersonel;
    }

    public void setFonctionpersonel(fdsa.edu.pnu.Model.Fonction value) {
        this.fonctionpersonel = value;
    }

    public String toString() {
        return super.toString();
    }

}
