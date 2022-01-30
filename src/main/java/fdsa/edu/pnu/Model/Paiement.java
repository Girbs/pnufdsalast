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

	@Column(name="NumeroPaiement", nullable=true, length=255)
	private String numeroPaiement;

	@Column(name="Montant", nullable=true, precision=19, scale=0)
	private java.math.BigDecimal montant;

	@Column(name="DatePaiement", nullable=true)
	private java.sql.Timestamp datePaiement;

	@Column(name="Remarque", nullable=true, length=255)
	private String remarque;

	@ManyToOne(targetEntity= Semestre.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="SemestreID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="PaimentSemestre"))
	private Semestre semestre;
	 
	@ManyToOne(targetEntity= Etudiant.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="FK_PAIEMENTS_ETUDIANTS"))	
	private Etudiant etudiant;
	 
	@ManyToOne(targetEntity= TypePaiement.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="TypePaiementID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FK_PAIEMENTS_TYPES_PAIEMENT"))	
	private TypePaiement typePaiement;

	@OneToMany(mappedBy="paiement", targetEntity= Requete.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private final java.util.Set requetes = new java.util.HashSet();

}
