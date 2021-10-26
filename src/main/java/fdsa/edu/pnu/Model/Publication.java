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
@Table(name="Publication")
public class Publication implements Serializable {
	public Publication() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PUBLICATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PUBLICATION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Professeur.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProfesseurPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="faire"))	
	private Professeur professeur;
	
	@Column(name="`Date`", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date Date;
	
	@Column(name="Description", nullable=true, length=255)	
	private String Description;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDate(java.util.Date value) {
		this.Date = value;
	}
	
	public java.util.Date getDate() {
		return Date;
	}
	
	public void setDescription(String value) {
		this.Description = value;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setTitre(String value) {
		this.titre = value;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setProfesseur(Professeur value) {
		this.professeur = value;
	}
	
	public Professeur getProfesseur() {
		return professeur;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
