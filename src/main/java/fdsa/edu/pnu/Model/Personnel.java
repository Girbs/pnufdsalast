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

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "Personnel")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Personnel")
public class Personnel extends Utilisateur implements Serializable {
    @ManyToOne(targetEntity = Fonction.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "FonctionID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "FKPersonnel768785"))
    private Fonction fonctionpersonel;

    public Personnel() {
    }

    public Fonction getFonctionpersonel() {
        return fonctionpersonel;
    }

    public void setFonctionpersonel(Fonction value) {
        this.fonctionpersonel = value;
    }

    public String toString() {
        return super.toString();
    }

}
