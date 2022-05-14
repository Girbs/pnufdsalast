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

import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Model.Postulant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CoursDAO extends JpaRepository<Cours, Integer> {

    @Query(value = "SELECT * FROM Cours  WHERE  CONCAT( nom , prenom, adresse, email , telephone, statut_application) LIKE %:text%", nativeQuery = true)
    Page<Postulant> findByAllDynameicSearch(@Param("text") String text, Pageable pageable);


    @Query("SELECT c FROM  Cours c WHERE c.id  = :idNouveauCours")
    Cours findCoursProgramByIdCours(@Param("idNouveauCours") Integer idNouveauCours);

    @Query(value = "{call ListCoursDiponiblesPourEdudiant(:idEtudiant,:idProgramme)}", nativeQuery = true)
    List<Cours> ListCoursDiponiblesPourEdudiant(@Param("idEtudiant") Integer idEtudiant, @Param("idProgramme") Integer idProgramme);

}
