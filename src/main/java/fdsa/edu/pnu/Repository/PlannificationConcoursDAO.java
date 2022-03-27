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


import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.Model.PlannificationConcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannificationConcoursDAO extends JpaRepository<PlannificationConcours, Integer> {
    @Query(value = "SELECT * FROM plannification_concours  WHERE  CONCAT(commentaire,quotation )  LIKE %:text%", nativeQuery = true)
    Page<PlannificationConcours> findByAllPlannificationConcoursDynamiqueSearch(@Param("text") String text, Pageable pageable);

    @Query(value = "{call FindPlannificationConcoursById(:IdPlannificationConcours)}", nativeQuery = true)
    PlannificationConcours findPlannificationConcoursById(@Param("IdPlannificationConcours") Integer IdPlannificationConcours);

    @Query(value = "{call FindPlannificationConcoursByIdConcours(:IdConcours)}", nativeQuery = true)
    List<PlannificationConcours> findPlannificationConcoursByIdConcours(@Param("IdConcours") Integer IdConcours);


}
