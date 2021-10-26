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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
@Entity
@Data
@org.hibernate.annotations.Proxy(lazy=false)

@Table(name="AnneeAcademique")
public class AnneeAcademique implements Serializable {
	public AnneeAcademique() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_ANNEEACADEMIQUE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_ANNEEACADEMIQUE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="Debut", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date debut;
	
	@Column(name="Fin", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fin;
	
	@ManyToMany(mappedBy="anneeAcademiques", targetEntity= Cours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set cours = new java.util.HashSet();
        
	@OneToMany(mappedBy="anneeAcademique", targetEntity= Paiement.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
        private java.util.Set paiements = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDebut(java.util.Date value) {
		this.debut = value;
	}
	
	public java.util.Date getDebut() {
		return debut;
	}
	
	public void setFin(java.util.Date value) {
		this.fin = value;
	}
	
	public java.util.Date getFin() {
		return fin;
	}
	
	public void setCours(java.util.Set value) {
		this.cours = value;
	}
	
	public java.util.Set getCours() {
		return cours;
	}
	
 
	
	public void setPaiements(java.util.Set value) {
		this.paiements = value;
	}
	@JsonManagedReference
	public java.util.Set getPaiements() {
		return paiements;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
