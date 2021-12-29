package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Evaluation;

import java.util.List;
import java.util.Optional;

public interface IEvaluationService {
    public List<Evaluation> findAll();

    public Optional<Evaluation> findById(Integer id);

    public Evaluation save(Evaluation dto);

    public void delete(Integer id);
}
