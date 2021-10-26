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
@Table(name="Evaluation")
public class Evaluation implements Serializable {
	public Evaluation() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_EVALUATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_EVALUATION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Cours.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CoursID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FK_EVALUATIONS_COURS"))	
	private Cours cours;
	
	@Column(name="DateEvaluation", nullable=false)	
	private java.sql.Timestamp dateEvaluation;
	
	@Column(name="`Session`", nullable=true, length=255)	
	private String session;
	
	@Column(name="CotationPourcentage", nullable=true, precision=19, scale=0)	
	private java.math.BigDecimal cotationPourcentage;
	
	@Column(name="TypeEvaluation", nullable=true, length=255)	
	private String typeEvaluation;
	
	@OneToOne(mappedBy="evaluation", targetEntity= HistoriqueExam.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private HistoriqueExam historiqueExam;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDateEvaluation(java.sql.Timestamp value) {
		this.dateEvaluation = value;
	}
	
	public java.sql.Timestamp getDateEvaluation() {
		return dateEvaluation;
	}
	
	public void setSession(String value) {
		this.session = value;
	}
	
	public String getSession() {
		return session;
	}
	
	public void setCotationPourcentage(java.math.BigDecimal value) {
		this.cotationPourcentage = value;
	}
	
	public java.math.BigDecimal getCotationPourcentage() {
		return cotationPourcentage;
	}
	
	public void setTypeEvaluation(String value) {
		this.typeEvaluation = value;
	}
	
	public String getTypeEvaluation() {
		return typeEvaluation;
	}
	
	public void setCours(Cours value) {
		this.cours = value;
	}
	
	public Cours getCours() {
		return cours;
	}
	
	public Etudiant getEtudiant() {
		if(historiqueExam != null) {
			return historiqueExam.getEtudiant();
		}
		else {
			return null;
		}
	}
	
	public void removeEtudiant() {
		if(historiqueExam!= null) {
			historiqueExam.setEtudiant(null);
			this.setHistoriqueExam(null);
		}
	}
	
	public void addEtudiant(HistoriqueExam aHistoriqueExam, Etudiant aEtudiant) {
		this.setHistoriqueExam(aHistoriqueExam);
		aHistoriqueExam.setEtudiant(aEtudiant);
	}
	
	public void setHistoriqueExam(HistoriqueExam value) {
		this.historiqueExam = value;
	}
	
	public HistoriqueExam getHistoriqueExam() {
		return historiqueExam;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
