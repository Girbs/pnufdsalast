package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Semestre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SemestreDTO {

    private int id;
    private String codeSemestre;
    private String description;
    private java.util.Date debut;
    private java.util.Date fin;
    private Integer anneAcademiqueId;

    private static ModelMapper mapper = new ModelMapper();

    public static SemestreDTO fromEntity(Semestre semestre) {
        SemestreDTO semestreDto = mapper.map(semestre, SemestreDTO.class);
        return semestreDto;
    }

    public static Semestre toEntity(SemestreDTO semestreDTO) {
        Semestre semestre = mapper.map(semestreDTO, Semestre.class);
        return semestre;
    }
}
