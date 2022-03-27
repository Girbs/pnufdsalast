package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Etudiant;
import org.modelmapper.ModelMapper;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.DTO
 * @Date: Sep 25, 2021
 * @Subclass EtudiantDTO Description:
 */
//Imports
//Begin Subclass EtudiantDTO
public class EtudiantDTO {

    private static final ModelMapper mapper = new ModelMapper();
    private Integer id;
    private String commune;
    private String nom;
    private String prenom;
    private String cinNif;
    private String sexe;
    private String telephone1;
    private String telephone2;
    private String adresse;
    private String codePostal;
    private String status;
    private String userName;
    private String matricule;

    public static EtudiantDTO fromEntity(Etudiant etudiant) {

        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        EtudiantDTO etudiantDTO = mapper.map(etudiant, EtudiantDTO.class);
        return etudiantDTO;
    }

    public static Etudiant toEntity(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = mapper.map(etudiantDTO, Etudiant.class);
        return etudiant;
    }

}
