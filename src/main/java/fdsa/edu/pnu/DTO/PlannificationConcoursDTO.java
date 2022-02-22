/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.PlannificationConcours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Collection;

/**
 * @author Ing.Girbson BIJOU
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlannificationConcoursDTO {

    private static ModelMapper mapper = new ModelMapper();
    private int id;
    private Integer concoursid;
    private Integer matiereid;
    private java.util.Date Date;
    private double quotation;
    private double noteDePassage;
    private Collection<HistoriqueExamenConcoursDTO> historiqueExamenConcours;

    public static PlannificationConcoursDTO fromEntity(PlannificationConcours plannificationConcours) {

        PlannificationConcoursDTO plannificationConcoursDTO = mapper.map(plannificationConcours, PlannificationConcoursDTO.class);
        return plannificationConcoursDTO;

//        if (plannificationConcours == null) {
//            return null;
//        }
//        return PlannificationConcoursDTO.builder()
//                .id(plannificationConcours.getId())
//                .concours(ConcoursDTO.fromEntity(plannificationConcours.getConcours()))
//                .matiere(MatiereDTO.fromEntity(plannificationConcours.getMatiere()))
//                .Date(plannificationConcours.getDate())
//                .quotation(plannificationConcours.getQuotation())
//                .noteDePassage(plannificationConcours.getNoteDePassage())
//                .historiqueExamenConcoursCollection(plannificationConcours.getHistoriqueExamenConcourss())
//                .build();
    }


    public static PlannificationConcours toEntity(PlannificationConcoursDTO plannificationConcoursDTO) {

        PlannificationConcours pc = mapper.map(plannificationConcoursDTO, PlannificationConcours.class);

//        if (pcDTO == null) {
//            return null;
//        }
//        PlannificationConcours pc = new PlannificationConcours();
//
//        pc.setConcours(ConcoursDTO.toEntity(pcDTO.getConcours()));
//        pc.setMatiere(MatiereDTO.toEntity(pcDTO.getMatiere()));
//        pc.setDate(pcDTO.getDate());
//        pc.setQuotation(pcDTO.getQuotation());
//        pc.setNoteDePassage(pcDTO.noteDePassage);
//        pc.setHistoriqueExamenConcourss((Set) pcDTO.getHistoriqueExamenConcoursCollection());
        return pc;
    }
}
