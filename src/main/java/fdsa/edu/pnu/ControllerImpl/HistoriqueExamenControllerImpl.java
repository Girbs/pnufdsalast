package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHistoriqueExamenController;
import fdsa.edu.pnu.Model.HistoriqueEvaluation;
import fdsa.edu.pnu.ServiceImpl.HistoriqueExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
public class HistoriqueExamenControllerImpl implements IHistoriqueExamenController {
    @Autowired
    private HistoriqueExamServiceImpl historiqueExamServiceImpl;

//    @Autowired
//    private StorageService storageService;

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
    public HistoriqueEvaluation save(HistoriqueEvaluation historiqueEvaluation, MultipartFile file) {
      //  String filename= storageService.uploadFile(file);
      //  historiqueEvaluationOrdinaire.setLienFichier(filename);
        return historiqueExamServiceImpl.save(historiqueEvaluation, file);
    }

//    @Override
//    public String soumettreDevoir(SoumissionDevoir soumissionDevoir, MultipartFile fichier) {
//        return historiqueExamServiceImpl.soumettreDevoir(soumissionDevoir, fichier);
//    }
}


