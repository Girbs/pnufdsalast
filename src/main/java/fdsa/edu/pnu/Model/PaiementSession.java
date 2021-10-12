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
@Table(name = "PaiementSession")
public class PaiementSession implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PAIEMENTSESSION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PAIEMENTSESSION_ID_GENERATOR", strategy = "native")
    private int ID;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Etudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID")}, foreignKey = @ForeignKey(name = "Paimentetudiant"))
    private fdsa.edu.pnu.Model.Etudiant etudiant;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Session.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SessionID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_PaiementSession_Session"))
    private fdsa.edu.pnu.Model.Session session;
    @Column(name = "MontantPaiement", nullable = false, precision = 19, scale = 0)
    private java.math.BigDecimal montantPaiement;
    @Column(name = "Commentaire", nullable = true, length = 255)
    private String commentaire;
    @Column(name = "Attribute", nullable = false, length = 10)
    private int attribute;

    public PaiementSession() {
    }

    public int getID() {
        return ID;
    }

    private void setID(int value) {
        this.ID = value;
    }

    public int getORMID() {
        return getID();
    }

    public java.math.BigDecimal getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(java.math.BigDecimal value) {
        this.montantPaiement = value;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String value) {
        this.commentaire = value;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int value) {
        this.attribute = value;
    }

    public fdsa.edu.pnu.Model.Session getSession() {
        return session;
    }

    public void setSession(fdsa.edu.pnu.Model.Session value) {
        this.session = value;
    }

    public fdsa.edu.pnu.Model.Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(fdsa.edu.pnu.Model.Etudiant value) {
        this.etudiant = value;
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
