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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="Etudiant")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Etudiants")
public class Etudiant extends Utilisateur implements Serializable {
	
	
	@Column(name="CodeEtudiant")	
	private String codeEtudiant;
	
	@Column(name="Matricule")	
	private String matricule;
	
	@OneToMany(mappedBy="etudiant", targetEntity= PaiementSession.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set paiementSessions = new java.util.HashSet();
	
	@ManyToMany(targetEntity= Cours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Cours_Etudiant", joinColumns={ @JoinColumn(name="EtudiantPersonneID") }, inverseJoinColumns={ @JoinColumn(name="CoursID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set cours = new java.util.HashSet();
	
	@ManyToMany(targetEntity= Promotion.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Promotion_Etudiant", joinColumns={ @JoinColumn(name="EtudiantPersonneID") }, inverseJoinColumns={ @JoinColumn(name="PromotionID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set promotions = new java.util.HashSet();
	
	@ManyToMany(targetEntity= Programme.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Programme_Etudiant", joinColumns={ @JoinColumn(name="EtudiantPersonneID") }, inverseJoinColumns={ @JoinColumn(name="ProgrammeID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set programmes = new java.util.HashSet();
	
	@OneToOne(mappedBy="etudiant", targetEntity= HistoriqueExam.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private HistoriqueExam historiqueExam;
	
	@OneToMany(mappedBy="etudiant", targetEntity= Paiement.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set paiements = new java.util.HashSet();
	
	@OneToMany(mappedBy="etudiant", targetEntity= Stage.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set stages = new java.util.HashSet();
	
	@OneToMany(mappedBy="etudiant", targetEntity= Requete.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set requetes = new java.util.HashSet();
	
	@OneToMany(mappedBy="etudiant", targetEntity= Message.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set messages = new java.util.HashSet();
	
	
	
}
