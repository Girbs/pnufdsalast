package fdsa.edu.pnu.DTO;


import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Model.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurDTO extends UtilisateurDTO {


    private String codeProfesseur;
    private String titre;
    private String lienCv;
    private List<Cours> cours;
    private List<PublicationDTO> publications ;

    private static ModelMapper mapper = new ModelMapper();

    public static ProfesseurDTO fromEntity(Professeur professeur) {

        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        ProfesseurDTO professeurDTO = mapper.map(professeur, ProfesseurDTO.class);
        return professeurDTO;
    }

    public static Professeur toEntity(ProfesseurDTO professeurDTO) {
        Professeur professeur = mapper.map(professeurDTO, Professeur.class);
        return professeur;
    }

}
