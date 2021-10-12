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
@Table(name = "HistoriqueExam")
public class HistoriqueExam implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_HISTORIQUEEXAM_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_HISTORIQUEEXAM_ID_GENERATOR", strategy = "native")
    private int ID;
    @Column(name = "Note", nullable = false, length = 10)
    private double note;
    @OneToOne(targetEntity = fdsa.edu.pnu.Model.Etudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)})
    private fdsa.edu.pnu.Model.Etudiant etudiant;
    @OneToOne(targetEntity = fdsa.edu.pnu.Model.Evaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "EvaluationID", referencedColumnName = "ID", nullable = false)})
    private fdsa.edu.pnu.Model.Evaluation evaluation;

    public HistoriqueExam() {
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

    public double getNote() {
        return note;
    }

    public void setNote(double value) {
        this.note = value;
    }

    public fdsa.edu.pnu.Model.Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(fdsa.edu.pnu.Model.Evaluation value) {
        this.evaluation = value;
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
