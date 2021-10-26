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
@Table(name="Programme")
public class Programme implements Serializable {
	public Programme() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PROGRAMME_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PROGRAMME_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="Sigle", nullable=true, length=255)	
	private String sigle;
	
	@Column(name="Description", nullable=false, length=255)	
	private String description;
	
	@OneToMany(mappedBy="programme", targetEntity= Session.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set sessions = new java.util.HashSet();
	
	@ManyToMany(mappedBy="programmes", targetEntity= Etudiant.class)
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
	
	public void setSigle(String value) {
		this.sigle = value;
	}
	
	public String getSigle() {
		return sigle;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setSessions(java.util.Set value) {
		this.sessions = value;
	}
	
	public java.util.Set getSessions() {
		return sessions;
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
