/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


/**
 * @author Ing.Girbson BIJOU
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueExamenConcoursDTO {

    private static ModelMapper mapper = new ModelMapper();
    private Integer id;
    private double noteObtenue;
    private Integer plannificationConcoursId;
    private Integer postulantId;

    public static HistoriqueExamenConcoursDTO fromEntity(HistoriqueExamenConcours hec) {
        HistoriqueExamenConcoursDTO historiqueExamenConcoursDTO = mapper.map(hec, HistoriqueExamenConcoursDTO.class);
        historiqueExamenConcoursDTO.getPlannificationConcoursId().equals(hec.getPlannificationConcours().getId());
        // historiqueExamenConcoursDTO.getPlannificationConcoursId().equals(hec.getPlannificationConcours().getMatiere().getDescription());
        historiqueExamenConcoursDTO.getPlannificationConcoursId().equals(hec.getPlannificationConcours().getNoteDePassage());
        historiqueExamenConcoursDTO.getPostulantId().equals(hec.getPostulant().getId());
        return historiqueExamenConcoursDTO;
    }

    public static HistoriqueExamenConcours toEntity(HistoriqueExamenConcoursDTO hecdto) {
        HistoriqueExamenConcours historiqueExamenConcours = mapper.map(hecdto, HistoriqueExamenConcours.class);
        return historiqueExamenConcours;
    }

}
