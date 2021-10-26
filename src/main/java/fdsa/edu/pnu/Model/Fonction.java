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
@Table(name="Fonction")
public class Fonction implements Serializable {
	public Fonction() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_FONCTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_FONCTION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Departement.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="DepartementID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="FonctionDepartment"))	
	private Departement departement;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	@OneToMany(mappedBy="fonctionpersonel", targetEntity= Personnel.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set fonctionpersonel = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setTitre(String value) {
		this.titre = value;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setDepartement(Departement value) {
		this.departement = value;
	}
	
	public Departement getDepartement() {
		return departement;
	}
	
	public void setFonctionpersonel(java.util.Set value) {
		this.fonctionpersonel = value;
	}
	
	public java.util.Set getFonctionpersonel() {
		return fonctionpersonel;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
