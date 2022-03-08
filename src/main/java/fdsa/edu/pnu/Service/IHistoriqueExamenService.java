package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.HistoriqueEvaluationOrdinaire;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenService {

    List<HistoriqueEvaluationOrdinaire> findAll();

    Optional<HistoriqueEvaluationOrdinaire> findById(Integer id);

    HistoriqueEvaluationOrdinaire save(HistoriqueEvaluationOrdinaire historiqueEvaluationOrdinaire);


    void delete(Integer id);
}
