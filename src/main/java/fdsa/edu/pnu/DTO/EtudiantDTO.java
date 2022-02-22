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

    //	private java.util.Set paiementSessions = new java.util.HashSet();
//	private java.util.Set cours = new java.util.HashSet();
//	private java.util.Set promotions = new java.util.HashSet();
//	private java.util.Set programmes = new java.util.HashSet();
//	private fdsa.edu.pnu.Model.HistoriqueExam historiqueExam;
//	private java.util.Set paiements = new java.util.HashSet();
//	private java.util.Set stages = new java.util.HashSet();
//	private java.util.Set requetes = new java.util.HashSet();
//	private java.util.Set messages = new java.util.HashSet();
    private static final ModelMapper mapper = new ModelMapper();
    private String codeEtudiant;
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

} //End Subclass EtudiantDTO
