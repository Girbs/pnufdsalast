package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.HistoriqueEvaluation;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenService {

    List<HistoriqueEvaluation> findAll();
    Optional<HistoriqueEvaluation> findById(Integer id);
    HistoriqueEvaluation save(HistoriqueEvaluation historiqueEvaluation);
    List<HistoriqueEvaluation> findHistoriqueEvaluationByIdEvaluation  (Integer IdEvaluation);
    List< HistoriqueEvaluation>  findHistoriqueEvaluationByIdCoursEtudiant (Integer IdCoursEtudiant);

    double CalculerMoyenne(Integer IdEtudiantCours);
    void delete(Integer id);
}
