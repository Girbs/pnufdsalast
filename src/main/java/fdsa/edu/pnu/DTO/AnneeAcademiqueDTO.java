package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.AnneeAcademique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnneeAcademiqueDTO {

    private static ModelMapper mapper = new ModelMapper();
    private int id;
    private String codeAnneeAcademiquemestre;
    private java.util.Date debut;
    private java.util.Date fin;
    private Collection<SemestreDTO> semestres;
    private Collection<PaiementDTO> paiements;

    public static AnneeAcademiqueDTO fromEntity(AnneeAcademique anneeAcademique) {

        AnneeAcademiqueDTO anneeAcademiqueDTO = mapper.map(anneeAcademique, AnneeAcademiqueDTO.class);

        return anneeAcademiqueDTO;
    }

    public static AnneeAcademique toEntity(AnneeAcademiqueDTO anneeAcademiqueDTO) {
        AnneeAcademique anneeAcademique = mapper.map(anneeAcademiqueDTO, AnneeAcademique.class);
        return anneeAcademique;
    }

}
