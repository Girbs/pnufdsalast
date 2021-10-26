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
@Table(name="PaiementSession")
public class PaiementSession implements Serializable {
	public PaiementSession() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PAIEMENTSESSION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PAIEMENTSESSION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity= Etudiant.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID") }, foreignKey=@ForeignKey(name="Paimentetudiant"))	
	private Etudiant etudiant;
	
	@ManyToOne(targetEntity= Session.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="SessionID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FK_PaiementSession_Session"))	
	private Session session;
	
	@Column(name="MontantPaiement", nullable=false, precision=19, scale=0)	
	private java.math.BigDecimal montantPaiement;
	
	@Column(name="Commentaire", nullable=true, length=255)	
	private String commentaire;
	
	@Column(name="Attribute", nullable=false, length=10)	
	private int attribute;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setMontantPaiement(java.math.BigDecimal value) {
		this.montantPaiement = value;
	}
	
	public java.math.BigDecimal getMontantPaiement() {
		return montantPaiement;
	}
	
	public void setCommentaire(String value) {
		this.commentaire = value;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setAttribute(int value) {
		this.attribute = value;
	}
	
	public int getAttribute() {
		return attribute;
	}
	
	public void setSession(Session value) {
		this.session = value;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setEtudiant(Etudiant value) {
		this.etudiant = value;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
