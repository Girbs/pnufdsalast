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


import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.Model.Postulant;
import org.hibernate.LockMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;


public interface MatiereDAO extends JpaRepository<Matiere,Integer> {
    // This method is the same to the above one

    @Query(value ="SELECT * FROM Matiere  WHERE  CONCAT( description , code)  LIKE %:text%" , nativeQuery = true)
    Page<Matiere> findByAllMatiereDynamiqueSearch(@Param("text") String text , Pageable pageable);



}
