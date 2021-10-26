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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="Paiement")
public class Paiement implements Serializable {
	public Paiement() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PAIEMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PAIEMENT_ID_GENERATOR", strategy="native")	
	private int id;

        @ManyToOne(targetEntity= AnneeAcademique.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="AnneeAcademiqueID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="PaiementAnneeAcademique"))	
	private AnneeAcademique anneeAcademique;
	 
	@ManyToOne(targetEntity= Session.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="SessionID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="PaimentSession"))	
	private Session session;
	 
	@ManyToOne(targetEntity= Etudiant.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="FK_PAIEMENTS_ETUDIANTS"))	
	private Etudiant etudiant;
	 
	@ManyToOne(targetEntity= TypePaiement.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TypePaiementID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FK_PAIEMENTS_TYPES_PAIEMENT"))	
	private TypePaiement typePaiement;
	
	@Column(name="NumeroPaiement", nullable=true, length=255)	
	private String numeroPaiement;
	
	@Column(name="Montant", nullable=true, precision=19, scale=0)	
	private java.math.BigDecimal montant;
	
	@Column(name="DatePaiement", nullable=true)	
	private java.sql.Timestamp datePaiement;
	
	@Column(name="Remarque", nullable=true, length=255)	
	private String remarque;
	
	@OneToMany(mappedBy="paiement", targetEntity= Requete.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set requetes = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNumeroPaiement(String value) {
		this.numeroPaiement = value;
	}
	
	public String getNumeroPaiement() {
		return numeroPaiement;
	}
	
	public void setMontant(java.math.BigDecimal value) {
		this.montant = value;
	}
	
	public java.math.BigDecimal getMontant() {
		return montant;
	}
	
	public void setDatePaiement(java.sql.Timestamp value) {
		this.datePaiement = value;
	}
	
	public java.sql.Timestamp getDatePaiement() {
		return datePaiement;
	}
	
	public void setRemarque(String value) {
		this.remarque = value;
	}
	
	public String getRemarque() {
		return remarque;
	}
	
	public void setTypePaiement(TypePaiement value) {
		this.typePaiement = value;
	}
	
	public TypePaiement getTypePaiement() {
		return typePaiement;
	}
	
	public void setEtudiant(Etudiant value) {
		this.etudiant = value;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	
	public void setRequetes(java.util.Set value) {
		this.requetes = value;
	}
	
	public java.util.Set getRequetes() {
		return requetes;
	}
	
	
	public void setSession(Session value) {
		this.session = value;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setAnneeAcademique(AnneeAcademique value) {
		this.anneeAcademique = value;
	}
	@JsonBackReference
	public AnneeAcademique getAnneeAcademique() {
		return anneeAcademique;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
