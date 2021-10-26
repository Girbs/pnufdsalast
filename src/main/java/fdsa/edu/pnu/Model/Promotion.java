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
@Table(name="Promotion")
public class Promotion implements Serializable {
	public Promotion() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PROMOTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PROMOTION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="DateDedebut", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date DateDedebut;
	
	@Column(name="MontantFraisSession", nullable=false, length=10)	
	private double MontantFraisSession;
	
	@Column(name="MontantfraisGeneraux", nullable=true, length=10)	
	private double MontantfraisGeneraux;
	
	@Column(name="NomPromotion", nullable=true, length=255)	
	private String nomPromotion;
	
	@ManyToMany(mappedBy="promotions", targetEntity= Etudiant.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set etudiants = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDateDedebut(java.util.Date value) {
		this.DateDedebut = value;
	}
	
	public java.util.Date getDateDedebut() {
		return DateDedebut;
	}
	
	public void setMontantFraisSession(double value) {
		this.MontantFraisSession = value;
	}
	
	public double getMontantFraisSession() {
		return MontantFraisSession;
	}
	
	public void setMontantfraisGeneraux(double value) {
		this.MontantfraisGeneraux = value;
	}
	
	public double getMontantfraisGeneraux() {
		return MontantfraisGeneraux;
	}
	
	public void setNomPromotion(String value) {
		this.nomPromotion = value;
	}
	
	public String getNomPromotion() {
		return nomPromotion;
	}
	
	public void setEtudiants(java.util.Set value) {
		this.etudiants = value;
	}
	
	public java.util.Set getEtudiants() {
		return etudiants;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
