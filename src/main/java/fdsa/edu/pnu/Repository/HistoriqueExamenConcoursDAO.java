/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Repository;


import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import fdsa.edu.pnu.Model.Matiere;
import org.hibernate.LockMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HistoriqueExamenConcoursDAO extends JpaRepository<HistoriqueExamenConcours,Integer> {
    @Query(value ="SELECT * FROM historique_examen_concours  WHERE  CONCAT( note_obtenue)  LIKE %:text%" , nativeQuery = true)
    Page<HistoriqueExamenConcours> findByAllHistoriqueExamenConcoursDynamiqueSearch(@Param("text") String text , Pageable pageable);
}
