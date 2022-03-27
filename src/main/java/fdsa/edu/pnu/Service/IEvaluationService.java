package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Evaluation;

import java.util.List;
import java.util.Optional;

public interface IEvaluationService {
    List<Evaluation> findAll();

    Optional<Evaluation> findById(Integer id);

    Evaluation save(Evaluation dto);

    void delete(Integer id);

    List<Evaluation> findEvaluationsByOrganisationExamenId(Integer idOrganisationExamen);
}
