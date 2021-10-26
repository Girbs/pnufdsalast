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
@Table(name="Stage")
public class Stage implements Serializable {
	public Stage() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_STAGE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_STAGE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Etudiant.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="EtudiantStage"))	
	private Etudiant etudiant;
	
	@ManyToOne(targetEntity= Institution.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="InstitutionID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="Donner"))	
	private Institution institution;
	
	@Column(name="DateDebut", nullable=true)	
	private java.sql.Timestamp dateDebut;
	
	@Column(name="DateFin", nullable=true)	
	private java.sql.Timestamp dateFin;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	@Column(name="Commentaire", nullable=true, length=255)	
	private String commentaire;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDateDebut(java.sql.Timestamp value) {
		this.dateDebut = value;
	}
	
	public java.sql.Timestamp getDateDebut() {
		return dateDebut;
	}
	
	public void setDateFin(java.sql.Timestamp value) {
		this.dateFin = value;
	}
	
	public java.sql.Timestamp getDateFin() {
		return dateFin;
	}
	
	public void setTitre(String value) {
		this.titre = value;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setCommentaire(String value) {
		this.commentaire = value;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setInstitution(Institution value) {
		this.institution = value;
	}
	
	public Institution getInstitution() {
		return institution;
	}
	
	public void setEtudiant(Etudiant value) {
		this.etudiant = value;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
