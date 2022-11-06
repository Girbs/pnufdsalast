package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.SoumissionDevoir;
import fdsa.edu.pnu.Model.HistoriqueEvaluation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenService {

    List<HistoriqueEvaluation> findAll();

    Optional<HistoriqueEvaluation> findById(Integer id);

    HistoriqueEvaluation save(HistoriqueEvaluation historiqueEvaluation);

    List<HistoriqueEvaluation> findHistoriqueEvaluationByIdEvaluation(Integer IdEvaluation);

    List<HistoriqueEvaluation> findHistoriqueEvaluationByIdCoursEtudiant(Integer IdCoursEtudiant);

    double CalculerMoyenne(Integer IdEtudiantCours);

   // String soumettreDevoir(SoumissionDevoir soumissionDevoir, MultipartFile file );

    void delete(Integer id);
}
