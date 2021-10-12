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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Paiement")
public class Paiement implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PAIEMENT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PAIEMENT_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.AnneeAcademique.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "AnneeAcademiqueID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "PaiementAnneeAcademique"))
    private fdsa.edu.pnu.Model.AnneeAcademique anneeAcademique;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Session.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SessionID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "PaimentSession"))
    private fdsa.edu.pnu.Model.Session session;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Etudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_PAIEMENTS_ETUDIANTS"))
    private fdsa.edu.pnu.Model.Etudiant etudiant;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.TypePaiement.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "TypePaiementID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_PAIEMENTS_TYPES_PAIEMENT"))
    private fdsa.edu.pnu.Model.TypePaiement typePaiement;
    @Column(name = "NumeroPaiement", nullable = true, length = 255)
    private String numeroPaiement;
    @Column(name = "Montant", nullable = true, precision = 19, scale = 0)
    private java.math.BigDecimal montant;
    @Column(name = "DatePaiement", nullable = true)
    private java.sql.Timestamp datePaiement;
    @Column(name = "Remarque", nullable = true, length = 255)
    private String remarque;
    @OneToMany(mappedBy = "paiement", targetEntity = fdsa.edu.pnu.Model.Requete.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set requetes = new java.util.HashSet();

    public Paiement() {
    }

    public int getId() {
        return id;
    }

    private void setId(int value) {
        this.id = value;
    }

    public int getORMID() {
        return getId();
    }

    public String getNumeroPaiement() {
        return numeroPaiement;
    }

    public void setNumeroPaiement(String value) {
        this.numeroPaiement = value;
    }

    public java.math.BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(java.math.BigDecimal value) {
        this.montant = value;
    }

    public java.sql.Timestamp getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(java.sql.Timestamp value) {
        this.datePaiement = value;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String value) {
        this.remarque = value;
    }

    public fdsa.edu.pnu.Model.TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(fdsa.edu.pnu.Model.TypePaiement value) {
        this.typePaiement = value;
    }

    public fdsa.edu.pnu.Model.Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(fdsa.edu.pnu.Model.Etudiant value) {
        this.etudiant = value;
    }

    public java.util.Set getRequetes() {
        return requetes;
    }

    public void setRequetes(java.util.Set value) {
        this.requetes = value;
    }

    public fdsa.edu.pnu.Model.Session getSession() {
        return session;
    }

    public void setSession(fdsa.edu.pnu.Model.Session value) {
        this.session = value;
    }

    @JsonBackReference
    public fdsa.edu.pnu.Model.AnneeAcademique getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(fdsa.edu.pnu.Model.AnneeAcademique value) {
        this.anneeAcademique = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
