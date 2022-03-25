package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHistoriqueExamenController;
import fdsa.edu.pnu.Model.HistoriqueEvaluation;
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
    public List<HistoriqueEvaluation> findAll() {
        return historiqueExamServiceImpl.findAll();
    }

    @Override
    public List<HistoriqueEvaluation> findHistoriqueEvaluationByIdEvaluation(Integer IdEvaluation) {
        return historiqueExamServiceImpl.findHistoriqueEvaluationByIdEvaluation(IdEvaluation);
    }

    @Override
    public List<HistoriqueEvaluation> findHistoriqueEvaluationByIdCoursEtudiant(Integer IdCoursEtudiant) {
        return historiqueExamServiceImpl.findHistoriqueEvaluationByIdCoursEtudiant(IdCoursEtudiant);
    }

    @Override
    public Optional<HistoriqueEvaluation> findById(Integer id) {
        return historiqueExamServiceImpl.findById(id);
    }

    @Override
    public double note(Integer id) {
        return historiqueExamServiceImpl.CalculerMoyenne(id);
    }

    @Override
    public HistoriqueEvaluation update(Integer id, HistoriqueEvaluation historiqueEvaluationOrdinaire) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        historiqueExamServiceImpl.delete(id);
    }

    @Override
    public HistoriqueEvaluation save(HistoriqueEvaluation historiqueEvaluationOrdinaire) {
        return historiqueExamServiceImpl.save(historiqueEvaluationOrdinaire);
    }
}
