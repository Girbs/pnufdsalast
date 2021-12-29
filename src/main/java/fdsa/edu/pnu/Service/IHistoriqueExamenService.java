package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.HistoriqueExam;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenService {

    public List<HistoriqueExam> findAll();

    public Optional<HistoriqueExam> findById(Integer id);

    public HistoriqueExam save(HistoriqueExam historiqueExam);

    public void delete(Integer id);
}
