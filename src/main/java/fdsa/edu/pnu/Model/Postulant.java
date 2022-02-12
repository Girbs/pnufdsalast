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
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//@JsonIdentityReference(alwaysAsId = true)
@Table(name="Postulant")
public class Postulant implements Serializable {
	public Postulant() {
	}

	@Column(name="ID", nullable=false, length=10)
	@Id
	@GeneratedValue(generator="PNU_POSTULANT_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="PNU_POSTULANT_ID_GENERATOR", strategy="native")
	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
	private String adresseHopitalClinique;
	private String adresseDerniereInstitutionFrequentee;
	private String adresseEtudeUniversitaire;
	private String autreMaladie;
	private String maladie;
	private String autreNationalite;
	private Boolean nouveauPostulant;
	private String citoyennete;
	private String commune;
	private String consentementPostulant;
	private java.util.Date dateAncienneDemande;
	private java.util.Date datedObtentionBacc1;
	private java.util.Date datedObtentionBacc2;
	private java.util.Date dateDemande;
	private java.util.Date dateNaissance;
	private java.util.Date debutEtudeProfessionnelle;
	private java.util.Date debutEtudeUniversitaire;
	private String departement;
	private String directeurDerniereInstitutionFrequentee;
	private String directeurEtudeProfessionnelle;
	private String discplineEtudeUniversitaire;
	private java.util.Date emploiDateDebut1;
	private java.util.Date emploiDateDebut2;
	private java.util.Date emploiDateDebut3;
	private java.util.Date emploiDateFin1;
	private java.util.Date emploiDateFin2;
	private java.util.Date emploiDateFin3;
	private Boolean personneMaladive;
	private String etudeUniversitaireTelephone;
	private String filliere;
	private java.util.Date finEtudeProfessionnelle;
	private java.util.Date finEtudeUniversitaire;
	private String fonctionEmploi1;
	private String fonctionEmploi2;
	private String fonctionEmploi3;
	private String hopitalClinique;
	private String institutionEtudeUniversitaire;
	private String institutionEtudeProfessionnelle;
	private String langueUsage;
	private String langueMaternelle;
	private String lieuNaissance;
	private String medicamentsHabituels;
	private String matricule;
	private String medecinFamille;
	private String nifCin;
	private String nombreAnneeServiceHopital;
	private String nomDerniereInstitutionFrequentee;
	private String nomDoyenEtudeUniversitaire;
	private String nomEmployeur1;
	private String nomEmployeur2;
	private String nomEmployeur3;
	private String semestre;
	private String sexe;
	private String specialiteHopitalClinique;
	private String statutDiplomeUniversitaire;
	private String telephoneDerniereInstitutionFrequentee;
	private String telephoneEtudeProfessionnelle;
	private String telephoneHopital;
	private String titreDiplomeEtudeProfessionnelle;
	private String typeEmploi;
	private String typeEmploi2;
	private String typeEmploi3;
	private String typeEtudeSollicitee;
	private String vacationSollicitee;
	private String nomPersonneAcontacter;
	private String prenomPersonneAcontacter;
	private String telephonePersonneAcontacter;
	private String statutApplication;

	@OneToMany( fetch =FetchType.EAGER, mappedBy="postulant", targetEntity= HistoriqueExamenConcours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})

	private  List<HistoriqueExamenConcours> historiqueExamenConcourss;

	//	@OneToOne(optional=false, targetEntity=fdsa.edu.PNUFDSA.Model.Utlilisateur.class, fetch=FetchType.LAZY)
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinColumns(value={ @JoinColumn(name="UtlilisateurPersonneID", referencedColumnName="PersonneID", nullable=true) }, foreignKey=@ForeignKey(name="FKPostulant864673"))	
//	private fdsa.edu.PNUFDSA.Model.Utlilisateur etre;



}
