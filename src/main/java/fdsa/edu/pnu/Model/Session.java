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
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="`Session`")
public class Session implements Serializable {
	public Session() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_SESSION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_SESSION_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Programme.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProgrammeID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FK_SESSIONS_PROGRAMMES"))	
	private Programme programme;
	
	@Column(name="DescriptionSession", nullable=true, length=255)	
	private String descriptionSession;
	
	@Column(name="CodeSession", nullable=true, length=255)	
	private String codeSession;
	
	@Column(name="Ordre", nullable=false, length=10)	
	private int ordre;
	
//	@ManyToMany(targetEntity=fdsa.edu.pnu.Model.Cours.class)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinTable(name="Cours_Session", joinColumns={ @JoinColumn(name="SessionID") }, inverseJoinColumns={ @JoinColumn(name="CoursID") })	
//	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
//	private java.util.Set cours = new java.util.HashSet();
	
	@OneToMany(mappedBy="session", targetEntity= PaiementSession.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set paiementSessions = new java.util.HashSet();
        
        
        @OneToMany(mappedBy="session", targetEntity= Cours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set cours = new java.util.HashSet();
	
	@OneToMany(mappedBy="session", targetEntity= Paiement.class)
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
	
	public void setDescriptionSession(String value) {
		this.descriptionSession = value;
	}
	
	public String getDescriptionSession() {
		return descriptionSession;
	}
	
	public void setCodeSession(String value) {
		this.codeSession = value;
	}
	
	public String getCodeSession() {
		return codeSession;
	}
	
	public void setOrdre(int value) {
		this.ordre = value;
	}
	
	public int getOrdre() {
		return ordre;
	}
	
	public void setProgramme(Programme value) {
		this.programme = value;
	}
	
	public Programme getProgramme() {
		return programme;
	}
	
	public void setCours(java.util.Set value) {
		this.cours = value;
	}
	
	public java.util.Set getCours() {
		return cours;
	}
	
	
	public void setPaiementSessions(java.util.Set value) {
		this.paiementSessions = value;
	}
	
	public java.util.Set getPaiementSessions() {
		return paiementSessions;
	}
	
	
	public void setPaiements(java.util.Set value) {
		this.paiements = value;
	}
	
	public java.util.Set getPaiements() {
		return paiements;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
