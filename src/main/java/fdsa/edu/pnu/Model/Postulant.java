/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 */

/**
 * Licensee: 
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "Postulant")
public class Postulant extends Audit<String> implements Serializable {
    public String statutApplication;
    public String commentaireDuDecanat;
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_POSTULANT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_POSTULANT_ID_GENERATOR", strategy = "native")
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
    private String lienFichier;
    private String lienFichierTest1;
    @JsonIgnoreProperties(value = {"postulant"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postulant", targetEntity = HistoriqueExamenConcours.class)
    private List<HistoriqueExamenConcours> historiqueExamenConcourss;

    @JsonIgnoreProperties(value = {"postulant"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postulant", targetEntity = ApplicationFile.class)
    private Set<ApplicationFile> applicationFiles;

    public Postulant() {
    }

}
