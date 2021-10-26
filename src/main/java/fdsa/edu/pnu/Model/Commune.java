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
@Table(name="Commune")
public class Commune implements Serializable {
	public Commune() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_COMMUNE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_COMMUNE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= DepartementGeographique.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="DepartementGeographiqueID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="appartenir"))	
	private DepartementGeographique departementGeographique;
	
	@Column(name="Description", nullable=true, length=255)	
	private String description;
	
	@OneToMany(mappedBy="commune", targetEntity= Personne.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set personne = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDepartementGeographique(DepartementGeographique value) {
		this.departementGeographique = value;
	}
	
	public DepartementGeographique getDepartementGeographique() {
		return departementGeographique;
	}
	
	public void setPersonne(java.util.Set value) {
		this.personne = value;
	}
	
	public java.util.Set getPersonne() {
		return personne;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
