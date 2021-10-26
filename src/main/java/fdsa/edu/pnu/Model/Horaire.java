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
public class Horaire implements Serializable {
	public Horaire() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_HORAIRE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_HORAIRE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity= Cours.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CoursID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="HoraireCours"))	
	private Cours cours;
	
	@Column(name="Jour", nullable=true, length=255)	
	private String jour;
	
	@Column(name="Heure", nullable=true, length=255)	
	private String heure;
	
	@Column(name="DatePremierCours", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date datePremierCours;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setJour(String value) {
		this.jour = value;
	}
	
	public String getJour() {
		return jour;
	}
	
	public void setHeure(String value) {
		this.heure = value;
	}
	
	public String getHeure() {
		return heure;
	}
	
	public void setDatePremierCours(java.util.Date value) {
		this.datePremierCours = value;
	}
	
	public java.util.Date getDatePremierCours() {
		return datePremierCours;
	}
	
	public void setCours(Cours value) {
		this.cours = value;
	}
	
	public Cours getCours() {
		return cours;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
