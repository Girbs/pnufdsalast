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

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostulantDTO {


    private Integer id;
//    @JsonProperty(value = "nom")
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

    private List<HistoriqueExamenConcoursDTO> historiqueExamenConcourss;

    private static ModelMapper mapper = new ModelMapper();

    public static PostulantDTO fromEntity(Postulant postulant) {
        // mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        PostulantDTO pDTO = mapper.map(postulant, PostulantDTO.class);

        return pDTO;

    }


//    {
//      
//        
//        
//        if (postulant == null) {
//            return null;
//        }
//        return PostulantDTO.builder()
//                .id(postulant.getId())
//                .adresse(postulant.getAdresse())
//                .adresseDerniereInstitutionFrequente(postulant.getAdresseDerniereInstitutionFrequente())
//                .adresseEtudeUniversitaire(postulant.getAdresseEtudeUniversitaire())
//                .adresseHopitalClinique(postulant.getAdresseHopitalClinique())
//                .autreMaladie(postulant.getAutreMaladie())
//                .autreNationalite(postulant.getAutreNationalite())
//                .nouveauPostulant(postulant.getNouveauPostulant())
//                .citoyennete(postulant.getCitoyennete())
//                .commune(postulant.getCommune())
//                .consentementPostulant(postulant.getConsentementPostulant())
//                .dateAncienneDemande(postulant.getDateAncienneDemande())
//                .dateDemande(postulant.getDateDemande())
//                .datedenaissance(postulant.getDatedenaissance())
//               .datedObtentionBacc1(postulant.getDatedObtentionBacc1())
//              .datedObtentionBacc2(postulant.getDatedObtentionBacc2())
//                .debutEtudeProfessionnelle(postulant.getDebutEtudeProfessionnelle())
//                .debutEtudeUniversitaire(postulant.getDebutEtudeUniversitaire())
//                .departement(postulant.getDepartement())
//                .directeurDernireInstitutionFrquente(postulant.getDirecteurDernireInstitutionFrquente())
//                .directeurEtudeProfessionnelle(postulant.getDirecteurEtudeProfessionnelle())
//                .discplineEtudeSecondaire(postulant.getDiscplineEtudeSecondaire())
//                .email(postulant.getEmail())
//                .emploiDateDebut1(postulant.getEmploiDateDebut1())
//                .emploiDateDebut2(postulant.getEmploiDateDebut2())
//                .emploiDateDebut3(postulant.getEmploiDateDebut3())
//                .emploiDateFin1(postulant.getEmploiDateFin1())
//                .emploiDateFin2(postulant.getEmploiDateFin2())
//                .emploiDateFin3(postulant.getEmploiDateFin3())
//                .personneMaladive(postulant.getPersonneMaladive())
//                .etudeUniversitaireTelephone(postulant.getEtudeUniversitaireTelephone())
//                .filliere(postulant.getFilliere())
//                .finEtudeProfessionnelles(postulant.getFinEtudeProfessionnelles())
//                .finEtudeUniversitaire(postulant.getFinEtudeUniversitaire())
//                .fonctionEmploi1(postulant.getFonctionEmploi1())
//                .fonctionEmploi2(postulant.getFonctionEmploi2())
//                .fonctionEmploi3(postulant.getFonctionEmploi3())
//                .hopitalClinique(postulant.getHopitalClinique())
//                .indiqueznousvotremaladie(postulant.getIndiqueznousvotremaladie())
//                .instititionEtudeUniversitaire(postulant.getInstititionEtudeUniversitaire())
//                .institutionEtudeProfessionnelles(postulant.getInstitutionEtudeProfessionnelles())
//                .jedsireentreprendremestudesla(postulant.getJedsireentreprendremestudesla())
//                .langueMaternelle(postulant.getLangueMaternelle())
//                .languedusage(postulant.getLanguedusage())
//                .lieunaissance(postulant.getLieunaissance())
//                .listedevosmdicamentshabituels(postulant.getListedevosmdicamentshabituels())
//                .matricule(postulant.getMatricule())
//                .medecinFamille(postulant.getMedecinFamille())
//                .nifCin(postulant.getNifCin())
//                .nom(postulant.getNom())
//                .nomDernireInstitutionFrequente(postulant.getNomDernireInstitutionFrequente())
//                .nomDuDoyenEtudeUnirversitaire(postulant.getNomDuDoyenEtudeUnirversitaire())
//                .nomEmployeur1(postulant.getNomEmployeur1())
//                .nomEmployeur2(postulant.getNomEmployeur2())
//                .nomEmployeur3(postulant.getNomEmployeur3())
//                .nombredanneedeServicedelHopital(postulant.getNombredanneedeServicedelHopital())
//                .numberofLocations(postulant.getNumberofLocations())
//                .pourquelsemestre(postulant.getPourquelsemestre())
//                .prenom(postulant.getPrenom())
//                .primaire(postulant.getPrimaire())
//                .sexe(postulant.getSexe())
//                .siOuiPrecisezladatedelademande(postulant.getSiOuiPrecisezladatedelademande())
//                .specialiteHopitalClinique(postulant.getSpecialiteHopitalClinique())
//                .statutDiplomeUniversitaire(postulant.getStatutDiplomeUniversitaire())
//                .telephone1(postulant.getTelephone1())
//                .telephone2(postulant.getTelephone2())
//                .telephoneHopital(postulant.getTelephoneHopital())
//                .titreDiplomeEtudeProfessionnelles(postulant.getTitreDiplomeEtudeProfessionnelles())
//                .tlphoneDernireInstitutionFrquent(postulant.getTlphoneDernireInstitutionFrquent())
//                .tlphoneEtudeProfessionnelles(postulant.getTlphoneEtudeProfessionnelles())
//                .typeDetudeSollicite(postulant.getTypeDetudeSollicite())
//                .typedemploi(postulant.getTypedemploi())
//                .typedemploi2(postulant.getTypedemploi2())
//                .typedemploi3(postulant.getTypedemploi3())
//                .urgenceNom1(postulant.getUrgenceNom1())
//                .urgenceNom2(postulant.getUrgenceNom2())
//                .urgencePrnom1(postulant.getUrgencePrnom1())
//                .urgencePrnom2(postulant.getUrgencePrnom2())
//                .vacationsollicite(postulant.getVacationsollicite())
//                .historiqueExamenConcoursCollection(postulant.getHistoriqueExamenConcourss())
//                
//                .build();
//    }

    public static Postulant toEntity(PostulantDTO postulantDto) {

        Postulant postulant = mapper.map(postulantDto, Postulant.class);


//        if (postulantDto == null) {
//            return null;
//        }
//        Postulant postulant = new Postulant();
//        // postulant.setId(postulantDto.getId());
//        postulant.setAdresse(postulantDto.getAdresse());
//        postulant.setAdresseDerniereInstitutionFrequente(postulantDto.getAdresseDerniereInstitutionFrequente());
//        postulant.setAdresseEtudeUniversitaire(postulantDto.getAdresseEtudeUniversitaire());
//        postulant.setAdresseHopitalClinique(postulantDto.getAdresseHopitalClinique());
//        postulant.setAutreMaladie(postulantDto.getAutreMaladie());
//        postulant.setAutreNationalite(postulantDto.getAutreNationalite());
//        postulant.setNouveauPostulant(postulantDto.getNouveauPostulant());
//        postulant.setCitoyennete(postulantDto.getCitoyennete());
//        postulant.setCommune(postulantDto.getCommune());
//        postulant.setConsentementPostulant(postulantDto.getConsentementPostulant());
//        postulant.setDateAncienneDemande(postulantDto.getDateAncienneDemande());
//        postulant.setDateDemande(postulantDto.getDateDemande());
//        postulant.setDatedenaissance(postulantDto.getDatedenaissance());
//        postulant.setDatedObtentionBacc1(postulantDto.getDatedObtentionBacc1());
//        postulant.setDatedObtentionBacc2(postulantDto.getDatedObtentionBacc2());
//        postulant.setDebutEtudeProfessionnelle(postulantDto.getDebutEtudeProfessionnelle());
//        postulant.setDebutEtudeUniversitaire(postulantDto.getDebutEtudeUniversitaire());
//        postulant.setDepartement(postulantDto.getDepartement());
//        postulant.setDirecteurDernireInstitutionFrquente(postulantDto.getDirecteurDernireInstitutionFrquente());
//        postulant.setDirecteurEtudeProfessionnelle(postulantDto.getDirecteurEtudeProfessionnelle());
//        postulant.setDiscplineEtudeSecondaire(postulantDto.getDiscplineEtudeSecondaire());
//        postulant.setEmail(postulantDto.getEmail());
//        postulant.setEmploiDateDebut1(postulantDto.getEmploiDateDebut1());
//        postulant.setEmploiDateDebut2(postulantDto.getEmploiDateDebut2());
//        postulant.setEmploiDateDebut3(postulantDto.getEmploiDateDebut3());
//        postulant.setEmploiDateFin1(postulantDto.getEmploiDateFin1());
//        postulant.setEmploiDateFin2(postulantDto.getEmploiDateFin2());
//        postulant.setEmploiDateFin3(postulantDto.getEmploiDateFin3());
//        postulant.setPersonneMaladive(postulantDto.getPersonneMaladive());
//        postulant.setEtudeUniversitaireTelephone(postulantDto.getEtudeUniversitaireTelephone());
//        postulant.setFilliere(postulantDto.getFilliere());
//        postulant.setFinEtudeProfessionnelles(postulantDto.getFinEtudeProfessionnelles());
//        postulant.setFinEtudeUniversitaire(postulantDto.getFinEtudeUniversitaire());
//        postulant.setFonctionEmploi1(postulantDto.getFonctionEmploi1());
//        postulant.setFonctionEmploi2(postulantDto.getFonctionEmploi2());
//        postulant.setFonctionEmploi3(postulantDto.getFonctionEmploi3());
//        postulant.setHopitalClinique(postulantDto.getHopitalClinique());
//        postulant.setIndiqueznousvotremaladie(postulantDto.getIndiqueznousvotremaladie());
//        postulant.setInstititionEtudeUniversitaire(postulantDto.getInstititionEtudeUniversitaire());
//        postulant.setInstitutionEtudeProfessionnelles(postulantDto.getInstitutionEtudeProfessionnelles());
//        postulant.setJedsireentreprendremestudesla(postulantDto.getJedsireentreprendremestudesla());
//        postulant.setLangueMaternelle(postulantDto.getLangueMaternelle());
//        postulant.setLanguedusage(postulantDto.getLanguedusage());
//        postulant.setLieunaissance(postulantDto.getLieunaissance());
//        postulant.setListedevosmdicamentshabituels(postulantDto.getListedevosmdicamentshabituels());
//        postulant.setMatricule(postulantDto.getMatricule());
//        postulant.setMedecinFamille( postulantDto.getMedecinFamille());
//    //    postulant.setNifcin(postulantDto.getNifcin());
//        postulant.setNom(postulantDto.getNom());
//        postulant.setNomDernireInstitutionFrequente(postulantDto.getNomDernireInstitutionFrequente());
//        postulant.setNomDuDoyenEtudeUnirversitaire(postulantDto.getNomDuDoyenEtudeUnirversitaire());
//        postulant.setNomEmployeur1(postulantDto.getNomEmployeur1());
//        postulant.setNomEmployeur2(postulantDto.getNomEmployeur2());
//        postulant.setNomEmployeur3(postulantDto.getNomEmployeur3());
//        postulant.setNombredanneedeServicedelHopital(postulantDto.getNombredanneedeServicedelHopital());
//        postulant.setNumberofLocations(postulantDto.getNumberofLocations());
//        postulant.setPourquelsemestre(postulantDto.getPourquelsemestre());
//        postulant.setPrenom(postulantDto.getPrenom());
//        postulant.setPrimaire(postulantDto.getPrimaire());
//        postulant.setSexe(postulantDto.getSexe());
//        postulant.setSiOuiPrecisezladatedelademande(postulantDto.getSiOuiPrecisezladatedelademande());
//        postulant.setSpecialiteHopitalClinique(postulantDto.getSpecialiteHopitalClinique());
//        postulant.setStatutDiplomeUniversitaire(postulantDto.getStatutDiplomeUniversitaire());
//        postulant.setTelephone1(postulantDto.getTelephone1());
//        postulant.setTelephone2(postulantDto.getTelephone2());
//        postulant.setTelephoneHopital(postulantDto.getTelephoneHopital());
//        postulant.setTitreDiplomeEtudeProfessionnelles(postulantDto.getTitreDiplomeEtudeProfessionnelles());
//        postulant.setTlphoneDernireInstitutionFrquent(postulantDto.getTlphoneDernireInstitutionFrquent());
//        postulant.setTlphoneEtudeProfessionnelles(postulantDto.getTlphoneEtudeProfessionnelles());
//        postulant.setTypeDetudeSollicite(postulantDto.getTypeDetudeSollicite());
//        postulant.setTypedemploi(postulantDto.getTypedemploi());
//        postulant.setTypedemploi2(postulantDto.getTypedemploi2());
//        postulant.setTypedemploi3(postulantDto.getTypedemploi3());
//        postulant.setUrgenceNom1(postulantDto.getUrgenceNom1());
//        postulant.setUrgenceNom2(postulantDto.getUrgenceNom2());
//        postulant.setUrgencePrnom1(postulantDto.getUrgencePrnom1());
//        postulant.setUrgencePrnom2(postulantDto.getUrgencePrnom2());
//        postulant.setVacationsollicite(postulantDto.getVacationsollicite());
//       // postulant.setLastModifiedDate(postulantDto.getLastModifiedDate());
//      //  postulant.setCreationDate(Instant.EPOCH);
        return postulant;
    }


}
