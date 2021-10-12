/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.DTO;


import fdsa.edu.pnu.Model.Postulant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostulantDTO {


    private static ModelMapper mapper = new ModelMapper();
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

    public static PostulantDTO fromEntity(Postulant postulant) {
        // mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        PostulantDTO pDTO = mapper.map(postulant, PostulantDTO.class);

        return pDTO;

    }
    // private List<HistoriqueExamenConcoursDTO> historiqueExamenConcourss;

    public static Postulant toEntity(PostulantDTO postulantDto) {

        Postulant postulant = mapper.map(postulantDto, Postulant.class);


        return postulant;
    }

    public String getStatutApplication() {
        return statutApplication;
    }

    public void setStatutApplication(String statutApplication) {
        this.statutApplication = statutApplication;
    }


}
