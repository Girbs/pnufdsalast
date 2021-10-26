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
@Table(name="DepartementGeographique")
public class DepartementGeographique implements Serializable {
	public DepartementGeographique() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_DEPARTEMENTGEOGRAPHIQUE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_DEPARTEMENTGEOGRAPHIQUE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="Description", nullable=false, length=255)	
	private String description;
	
	@OneToMany(mappedBy="departementGeographique", targetEntity= Commune.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set commune = new java.util.HashSet();
	
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
	
	public void setCommune(java.util.Set value) {
		this.commune = value;
	}
	
	public java.util.Set getCommune() {
		return commune;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
