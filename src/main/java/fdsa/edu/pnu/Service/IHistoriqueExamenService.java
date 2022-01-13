package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.HistoriqueExam;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenService {

    List<HistoriqueExam> findAll();

    Optional<HistoriqueExam> findById(Integer id);

    HistoriqueExam save(HistoriqueExam historiqueExam);

    void delete(Integer id);
}
