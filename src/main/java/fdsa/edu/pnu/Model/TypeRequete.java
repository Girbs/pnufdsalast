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
@Table(name="TypeRequete")
public class TypeRequete implements Serializable {
	public TypeRequete() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof TypeRequete))
			return false;
		TypeRequete typerequete = (TypeRequete)aObj;
		return (getType() == null || getType().equals(typerequete.getType())) && (getType() != null || typerequete.getType() == null);
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getType() == null ? 0 : getType().hashCode());
		return hashcode;
	}
	
	@Column(name="ID", nullable=false, length=255)	
	@Id	
	private String type;
	
	@OneToMany(mappedBy="typeRequete", targetEntity= Requete.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set requetes = new java.util.HashSet();
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public String getORMID() {
		return getType();
	}
	
	public void setRequetes(java.util.Set value) {
		this.requetes = value;
	}
	
	public java.util.Set getRequetes() {
		return requetes;
	}
	
	
	public String toString() {
		return String.valueOf(getType());
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
