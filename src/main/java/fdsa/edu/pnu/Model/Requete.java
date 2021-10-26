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
@Table(name="Requete")
public class Requete implements Serializable {
	public Requete() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_REQUETE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_REQUETE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Etudiant.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="faire2"))	
	private Etudiant etudiant;
	
	@ManyToOne(targetEntity= Paiement.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PaiementID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKRequete827298"))	
	private Paiement paiement;
	
	@ManyToOne(targetEntity= TypeRequete.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TypeRequeteID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="Concerner2"))	
	private TypeRequete typeRequete;
	
	@Column(name="`Date`", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date date;
	
	@Column(name="Statut", nullable=true, length=255)	
	private String statut;
	
	@Column(name="Description", nullable=true, length=255)	
	private String Description;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setStatut(String value) {
		this.statut = value;
	}
	
	public String getStatut() {
		return statut;
	}
	
	public void setDescription(String value) {
		this.Description = value;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setEtudiant(Etudiant value) {
		this.etudiant = value;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	public void setTypeRequete(TypeRequete value) {
		this.typeRequete = value;
	}
	
	public TypeRequete getTypeRequete() {
		return typeRequete;
	}
	
	public void setPaiement(Paiement value) {
		this.paiement = value;
	}
	
	public Paiement getPaiement() {
		return paiement;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
