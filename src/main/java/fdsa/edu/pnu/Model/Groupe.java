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
@Table(name="Groupe")
public class Groupe implements Serializable {
	public Groupe() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_GROUPE_IDGROUPE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_GROUPE_IDGROUPE_GENERATOR", strategy="native")	
	private int idGroupe;
	
//	@ManyToMany(targetEntity=fdsa.edu.pnu.Model.Utilisateur.class)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinTable(name="Utlilisateur_Groupe", joinColumns={ @JoinColumn(name="GroupeID") }, inverseJoinColumns={ @JoinColumn(name="UtlilisateurPersonneID") })	
//	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
//	private java.util.Set utlilisateurs = new java.util.HashSet();
	
	@Column(name="Nom", nullable=true, length=255)	
	private String nom;
	
	@Column(name="Photo", nullable=true, length=255)	
	private String photo;
	
//	@ManyToOne(targetEntity=fdsa.edu.pnu.Model.Utilisateur.class, fetch=FetchType.LAZY)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinColumns(value={ @JoinColumn(name="UtlilisateurPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="Creer"))	
//	private fdsa.edu.pnu.Model.Utilisateur utlilisateur;
	
	@ManyToMany(mappedBy="groupe", targetEntity= Discussion.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set discussion = new java.util.HashSet();
	
	public void setNom(String value) {
		this.nom = value;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPhoto(String value) {
		this.photo = value;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	private void setIdGroupe(int value) {
		this.idGroupe = value;
	}
	
	public int getIdGroupe() {
		return idGroupe;
	}
	
	public int getORMID() {
		return getIdGroupe();
	}
//	
//	public void setUtlilisateurs(java.util.Set value) {
//		this.utlilisateurs = value;
//	}
//	
//	public java.util.Set getUtlilisateurs() {
//		return utlilisateurs;
//	}
//	
//	
//	public void setUtlilisateur(fdsa.edu.pnu.Model.Utilisateur value) {
//		this.utlilisateur = value;
//	}
//	
//	public fdsa.edu.pnu.Model.Utilisateur getUtlilisateur() {
//		return utlilisateur;
//	}
	
	public void setDiscussion(java.util.Set value) {
		this.discussion = value;
	}
	
	public java.util.Set getDiscussion() {
		return discussion;
	}
	
	
	public String toString() {
		return String.valueOf(getIdGroupe());
	}
	
}
