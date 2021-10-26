/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="HistoriqueExam")
public class HistoriqueExam implements Serializable {
	public HistoriqueExam() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_HISTORIQUEEXAM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_HISTORIQUEEXAM_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Note", nullable=false, length=10)	
	private double note;
	
	@OneToOne(targetEntity= Etudiant.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID", nullable=false) })	
	private Etudiant etudiant;
	
	@OneToOne(targetEntity= Evaluation.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="EvaluationID", referencedColumnName="ID", nullable=false) })	
	private Evaluation evaluation;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNote(double value) {
		this.note = value;
	}
	
	public double getNote() {
		return note;
	}
	
	public void setEvaluation(Evaluation value) {
		this.evaluation = value;
	}
	
	public Evaluation getEvaluation() {
		return evaluation;
	}
	
	public void setEtudiant(Etudiant value) {
		this.etudiant = value;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
