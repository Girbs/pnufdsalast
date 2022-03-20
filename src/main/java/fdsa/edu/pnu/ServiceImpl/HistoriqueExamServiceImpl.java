package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Model.HistoriqueEvaluation;
import fdsa.edu.pnu.Model.LogTracking;
import fdsa.edu.pnu.Repository.CoursEtudiantDAO;
import fdsa.edu.pnu.Repository.HistoriqueExamDAO;
import fdsa.edu.pnu.Repository.LogTrackingDAO;
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
    private LogTrackingDAO logTrackingDAO;
    @Autowired
    private CoursEtudiantDAO coursEtudiantDAO;
    @Autowired
    private CoursEtudiantServiceImpl coursEtudiantServiceImpl;
    @Override
    public List<HistoriqueEvaluation> findAll() {
        return historiqueExamDAO.findAll();
    }
    @Override
    public Optional<HistoriqueEvaluation> findById(Integer id) {
        return historiqueExamDAO.findById(id);
    }

    @Override
    public HistoriqueEvaluation save(HistoriqueEvaluation historiqueEvaluation) {
        int idCoursEtudiant = historiqueEvaluation.getCoursEtudiant().getId();
        System.out.println("The Sudent Id is: "+idCoursEtudiant);
        CoursEtudiant ce = coursEtudiantDAO.findById(idCoursEtudiant).get();
        double note = CalculerMoyenne(idCoursEtudiant);
        try {
            ce.setNote(note);
            coursEtudiantDAO.save(ce);
        } catch (Exception e) {
            logTrackingDAO.save(new LogTracking("Erreur lors du sauvegarde la moyenne:", e.toString()));
        }
        try {
            coursEtudiantServiceImpl.calculmoyenneHelper(ce);
            logTrackingDAO.save(new LogTracking("Appel de la methode coursEtudiantServiceImpl", "avec success"));
        } catch (Exception e) {
            logTrackingDAO.save(new LogTracking("Erreur dans l'appel du methode coursEtudiantServiceImpl", e.toString()));
        }
        return historiqueExamDAO.save(historiqueEvaluation);
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
