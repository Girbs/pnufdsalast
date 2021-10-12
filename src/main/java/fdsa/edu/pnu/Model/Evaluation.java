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
@Table(name = "Evaluation")
public class Evaluation implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EVALUATION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EVALUATION_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Cours.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_EVALUATIONS_COURS"))
    private fdsa.edu.pnu.Model.Cours cours;
    @Column(name = "DateEvaluation", nullable = false)
    private java.sql.Timestamp dateEvaluation;
    @Column(name = "`Session`", nullable = true, length = 255)
    private String session;
    @Column(name = "CotationPourcentage", nullable = true, precision = 19, scale = 0)
    private java.math.BigDecimal cotationPourcentage;
    @Column(name = "TypeEvaluation", nullable = true, length = 255)
    private String typeEvaluation;
    @OneToOne(mappedBy = "evaluation", targetEntity = fdsa.edu.pnu.Model.HistoriqueExam.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private fdsa.edu.pnu.Model.HistoriqueExam historiqueExam;

    public Evaluation() {
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

    public java.sql.Timestamp getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(java.sql.Timestamp value) {
        this.dateEvaluation = value;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String value) {
        this.session = value;
    }

    public java.math.BigDecimal getCotationPourcentage() {
        return cotationPourcentage;
    }

    public void setCotationPourcentage(java.math.BigDecimal value) {
        this.cotationPourcentage = value;
    }

    public String getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(String value) {
        this.typeEvaluation = value;
    }

    public fdsa.edu.pnu.Model.Cours getCours() {
        return cours;
    }

    public void setCours(fdsa.edu.pnu.Model.Cours value) {
        this.cours = value;
    }

    public fdsa.edu.pnu.Model.Etudiant getEtudiant() {
        if (historiqueExam != null) {
            return historiqueExam.getEtudiant();
        } else {
            return null;
        }
    }

    public void removeEtudiant() {
        if (historiqueExam != null) {
            historiqueExam.setEtudiant(null);
            this.setHistoriqueExam(null);
        }
    }

    public void addEtudiant(fdsa.edu.pnu.Model.HistoriqueExam aHistoriqueExam, fdsa.edu.pnu.Model.Etudiant aEtudiant) {
        this.setHistoriqueExam(aHistoriqueExam);
        aHistoriqueExam.setEtudiant(aEtudiant);
    }

    public fdsa.edu.pnu.Model.HistoriqueExam getHistoriqueExam() {
        return historiqueExam;
    }

    public void setHistoriqueExam(fdsa.edu.pnu.Model.HistoriqueExam value) {
        this.historiqueExam = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
