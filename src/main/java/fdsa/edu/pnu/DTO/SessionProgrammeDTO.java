package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.CoursProgramme;
import fdsa.edu.pnu.Model.Programme;
import lombok.Data;

import java.util.List;

@Data

public class SessionProgrammeDTO {

    private int id;
    private Programme programme;
    private String descriptionSession;
    private String codeSession;
    private int ordre;
    private List<CoursProgramme> coursProgrammes;


}

