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


import fdsa.edu.pnu.Model.SessionProgramme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionProgrammeDAO extends JpaRepository<SessionProgramme, Integer> {

    @Query(value = "SELECT * FROM session_programme", nativeQuery = true)
    List<SessionProgramme> findByAllCustomQuery();

    @Query(value = "{call FindSessionProgrammeById(:IdSessionProgramme)}", nativeQuery = true)
    SessionProgramme findSessionProgrammeById(@Param("IdSessionProgramme") Integer IdProgramme);

    @Query(value = "{call FindSessionProgrammeByIdProgramme(:IdProgramme)}", nativeQuery = true)
    List<SessionProgramme> findSessionProgrammeByIdProgramme(@Param("IdProgramme") Integer IdProgramme);

}
