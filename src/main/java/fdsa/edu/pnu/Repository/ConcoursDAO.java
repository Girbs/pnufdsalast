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

import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.Model.Postulant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ConcoursDAO extends JpaRepository<Concours, Integer> {
    @Query(value = "SELECT * FROM Concours  WHERE  CONCAT( description , code)  LIKE %:text%", nativeQuery = true)
    Page<Concours> findByAllConcoursDynamiqueSearch(@Param("text") String text, Pageable pageable);

    @Query(value = "SELECT * FROM Concours", nativeQuery = true)
    List<Concours> findByAllCustomQuery();

    @Query(value = "{call FindCoucoursById(:Idconcours)}", nativeQuery = true)
    Concours findConcoursById(@Param("Idconcours") Integer Idconcours);
}
