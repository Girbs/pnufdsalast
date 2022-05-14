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
package fdsa.edu.pnu.Repository;


import fdsa.edu.pnu.Model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EvaluationDAO extends JpaRepository<Evaluation, Integer> {

    @Query(value = "{call findEvaluationsByOrganisationExamenId(:idOrganisationExamen)}", nativeQuery = true)
    List<Evaluation> findEvaluationsByOrganisationExamenId(@Param("idOrganisationExamen") Integer idOrganisationExamen);
    List<Evaluation> findByCours(Integer idCours);

}
