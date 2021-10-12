/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Matiere;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatiereDTO {

    private static ModelMapper mapper = new ModelMapper();
    private int id;
    private String description;
    private String code;
    private String Contenu;
    private int nombreDeCreditStandard;
    private List<CoursDTO> cours;
    private Collection<PlannificationConcoursDTO> PlannificationConcours;

    public static MatiereDTO fromEntity(Matiere matiere) {

        MatiereDTO matiereDto = mapper.map(matiere, MatiereDTO.class);
        return matiereDto;
    }

    public static Matiere toEntity(MatiereDTO matiereDTO) {
        Matiere matiere = mapper.map(matiereDTO, Matiere.class);
        return matiere;
    }
}
