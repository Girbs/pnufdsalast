package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHistoriqueExamenController;
import fdsa.edu.pnu.Model.HistoriqueEvaluationOrdinaire;
import fdsa.edu.pnu.ServiceImpl.HistoriqueExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HistoriqueExamenControllerImpl implements IHistoriqueExamenController {
    @Autowired
    private HistoriqueExamServiceImpl historiqueExamServiceImpl;

    @Override
    public List<HistoriqueEvaluationOrdinaire> findAll() {
        return historiqueExamServiceImpl.findAll();
    }

    @Override
    public Optional<HistoriqueEvaluationOrdinaire> findById(Integer id) {
        return historiqueExamServiceImpl.findById(id);
    }

    @Override
    public HistoriqueEvaluationOrdinaire update(Integer id, HistoriqueEvaluationOrdinaire historiqueEvaluationOrdinaire) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        historiqueExamServiceImpl.delete(id);
    }

    @Override
    public HistoriqueEvaluationOrdinaire save(HistoriqueEvaluationOrdinaire historiqueEvaluationOrdinaire) {
        return historiqueExamServiceImpl.save(historiqueEvaluationOrdinaire);
    }
}
