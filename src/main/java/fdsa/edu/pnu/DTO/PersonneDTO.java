/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 */
/**
 * Licensee:
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Personne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDTO {

    private static ModelMapper mapper = new ModelMapper();
    private int id;
    //private fdsa.edu.pnu.Model.Commune commune;
    private String nom;
    private String prenom;
    private String cinNif;
    private String sexe;
    private String telephone1;
    private String telephone2;
    private String adresse;
    private String codePostal;

    public static PersonneDTO fromEntity(Personne personne) {

        PersonneDTO personneDto = mapper.map(personne, PersonneDTO.class);
        return personneDto;
    }

    public static Personne toEntity(PersonneDTO personneDto) {
        Personne personne = mapper.map(personneDto, Personne.class);
        return personne;
    }

}
