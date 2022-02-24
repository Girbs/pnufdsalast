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


import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Matiere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MatiereDAO extends JpaRepository<Matiere, Integer> {
    // This method is the same to the above one

    @Query(value = "SELECT * FROM Matiere  WHERE  CONCAT( description , code)  LIKE %:text%", nativeQuery = true)
    Page<Matiere> findByAllMatiereDynamiqueSearch(@Param("text") String text, Pageable pageable);

    @Query(value = "SELECT * FROM Matiere", nativeQuery = true)
    List<Matiere> findByAllCustumQuerry();

    @Query(value = "{call FindMatiereById(:Idmatiere)}", nativeQuery = true)
    Matiere findConcoursById(@Param("Idmatiere") Integer Idmatiere);

}
