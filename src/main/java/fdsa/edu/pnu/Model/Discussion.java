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
@Table(name="Discussion")
public class Discussion implements Serializable {
	public Discussion() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_DISCUSSION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_DISCUSSION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Cours.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CoursID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="CoursDiscussion"))	
	private Cours cours;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	@Column(name="Statut", nullable=true, length=255)	
	private String statut;
	
	@ManyToMany(targetEntity= Groupe.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Groupe_Discussion", joinColumns={ @JoinColumn(name="DiscussionID") }, inverseJoinColumns={ @JoinColumn(name="GroupeID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set groupe = new java.util.HashSet();
	
	@OneToMany(mappedBy="discussion", targetEntity= Message.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set messages = new java.util.HashSet();
	
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
	
	public void setStatut(String value) {
		this.statut = value;
	}
	
	public String getStatut() {
		return statut;
	}
	
	public void setGroupe(java.util.Set value) {
		this.groupe = value;
	}
	
	public java.util.Set getGroupe() {
		return groupe;
	}
	
	
	public void setCours(Cours value) {
		this.cours = value;
	}
	
	public Cours getCours() {
		return cours;
	}
	
	public void setMessages(java.util.Set value) {
		this.messages = value;
	}
	
	public java.util.Set getMessages() {
		return messages;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
