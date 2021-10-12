/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Concours;
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
public class ConcoursDTO {

    private static ModelMapper mapper = new ModelMapper();
    private Integer id;
    private java.util.Date DateDebut;
    private java.util.Date DateFin;
    private String description;
    private Collection<PlannificationConcoursDTO> PlannificationConcourses;

    public static ConcoursDTO fromEntity(Concours concours) {

        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        ConcoursDTO concoursDto = mapper.map(concours, ConcoursDTO.class);

        return concoursDto;
    }

    public static Concours toEntity(ConcoursDTO concoursDTO) {
        Concours concours = mapper.map(concoursDTO, Concours.class);
        return concours;
    }

}
