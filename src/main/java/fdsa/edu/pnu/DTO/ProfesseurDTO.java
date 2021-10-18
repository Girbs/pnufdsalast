package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Model.Professeur;
import fdsa.edu.pnu.Model.Publication;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class ProfesseurDTO {

    private static ModelMapper mapper = new ModelMapper();
    private String codeProfesseur;
    private String titre;
    private String lienCv;
    private Cours cours;
    private Set<Publication> publications;

    public static ProfesseurDTO fromEntity(Professeur professeur) {

        ProfesseurDTO professeurDTO = mapper.map(professeur, ProfesseurDTO.class);
        return professeurDTO;
    }

    public static Professeur toEntity(ProfesseurDTO professeurDTO) {
        Professeur professeur = mapper.map(professeurDTO, Professeur.class);
        return professeur;
    }

}
