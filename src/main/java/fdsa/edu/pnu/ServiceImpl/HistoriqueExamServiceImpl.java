package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Model.HistoriqueEvaluationOrdinaire;
import fdsa.edu.pnu.Repository.CoursEtudiantDAO;
import fdsa.edu.pnu.Repository.HistoriqueExamDAO;
import fdsa.edu.pnu.Service.IHistoriqueExamenService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class HistoriqueExamServiceImpl implements IHistoriqueExamenService {

    @Autowired
    private HistoriqueExamDAO historiqueExamDAO;

    @Autowired
    private CoursEtudiantDAO coursEtudiantDAO;

    @Override
    public List<HistoriqueEvaluationOrdinaire> findAll() {
        return historiqueExamDAO.findAll();
    }


    @Override
    public Optional<HistoriqueEvaluationOrdinaire> findById(Integer id) {
        return historiqueExamDAO.findById(id);
    }

    @Override
    public HistoriqueEvaluationOrdinaire save(HistoriqueEvaluationOrdinaire historiqueEvaluationOrdinaire) {
        int idCoursEtudiant = historiqueEvaluationOrdinaire.getCoursEtudiant().getId();
        Optional<CoursEtudiant> ce = coursEtudiantDAO.findById(idCoursEtudiant);
        double note = CalculerMoyenne(idCoursEtudiant);
        ce.get().setNote(note);
       // coursEtudiantDAO.save(ce);
        return historiqueExamDAO.save(historiqueEvaluationOrdinaire);
    }

    @Override
    public double CalculerMoyenne(Integer IdEtudiantCours) {
        return historiqueExamDAO.calculerMoyenne(IdEtudiantCours);
    }

    @Override
    public void delete(Integer id) {
        historiqueExamDAO.deleteById(id);
    }
}
