package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Config.AWSUtil;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class HistoriqueExamServiceImpl implements IHistoriqueExamenService {

    @Autowired
    private HistoriqueExamDAO historiqueExamDAO;

//    @Autowired
//    private StorageService storageService;
    @Autowired
    private LogTrackingDAO logTrackingDAO;

    @Autowired
    private AWSUtil awsUtil;
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

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";


    @Override
    public HistoriqueEvaluation save(HistoriqueEvaluation historiqueEvaluation, MultipartFile file) {

        String fileUrl = awsUtil.uploadFile(file);
        historiqueEvaluation.setLienFichier (fileUrl);

        int idCoursEtudiant = historiqueEvaluation.getCoursEtudiant().getId();

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
    public List<HistoriqueEvaluation> findHistoriqueEvaluationByIdEvaluation(Integer IdEvaluation) {
        return historiqueExamDAO.findHistoriqueEvaluationByIdEvaluation(IdEvaluation);
    }

    @Override
    public List<HistoriqueEvaluation> findHistoriqueEvaluationByIdCoursEtudiant(Integer IdCoursEtudiant) {
        return historiqueExamDAO.findHistoriqueEvaluationByIdCoursEtudiant(IdCoursEtudiant);
    }

    @Override
    public double CalculerMoyenne(Integer IdEtudiantCours) {
        return historiqueExamDAO.calculerMoyenne(IdEtudiantCours);
    }

//    @Override
//    public String soumettreDevoir(SoumissionDevoir soumissionDevoir, MultipartFile file) {
//
//        HistoriqueEvaluation he = new HistoriqueEvaluation();
//        String fileName =  storageService.uploadFile(file);
//        soumissionDevoir.setLienFichier(fileName);
//        BeanUtils.copyProperties(soumissionDevoir, he );
//        historiqueExamDAO.save(he);
//        return fileName;
//    }

    @Override
    public void delete(Integer id) {
        historiqueExamDAO.deleteById(id);
    }
}
