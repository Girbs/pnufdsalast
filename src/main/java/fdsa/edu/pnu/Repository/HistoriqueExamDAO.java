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


import fdsa.edu.pnu.Model.HistoriqueEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HistoriqueExamDAO extends JpaRepository<HistoriqueEvaluation, Integer> {

    @Query(value = "{call calculMoyenne(:IdCoursEtudiant)}", nativeQuery = true)
    double calculerMoyenne(@Param("IdCoursEtudiant") Integer IdCoursEtudiant);

    @Query(value = "{call findHistoriqueEvaluationByIdEvaluation(:IdEvaluation)}", nativeQuery = true)
    List<HistoriqueEvaluation> findHistoriqueEvaluationByIdEvaluation(@Param("IdEvaluation") Integer IdEvaluation);

    @Query(value = "{call findHistoriqueEvaluationByIdCoursEtudiant(:IdCoursEtudiant)}", nativeQuery = true)
    List<HistoriqueEvaluation> findHistoriqueEvaluationByIdCoursEtudiant(@Param("IdCoursEtudiant") Integer IdCoursEtudiant);

}
