/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Repository;


import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HistoriqueExamenConcoursDAO extends JpaRepository<HistoriqueExamenConcours, Integer> {
    @Query(value = "SELECT * FROM historique_examen_concours  WHERE  CONCAT( note_obtenue)  LIKE %:text%", nativeQuery = true)
    Page<HistoriqueExamenConcours> findByAllHistoriqueExamenConcoursDynamiqueSearch(@Param("text") String text, Pageable pageable);
}
