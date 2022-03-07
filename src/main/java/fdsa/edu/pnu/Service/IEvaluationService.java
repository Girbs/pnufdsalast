package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.EvaluationOrdinaire;

import java.util.List;
import java.util.Optional;

public interface IEvaluationService {
    List<EvaluationOrdinaire> findAll();

    Optional<EvaluationOrdinaire> findById(Integer id);

    EvaluationOrdinaire save(EvaluationOrdinaire dto);

    void delete(Integer id);
}
