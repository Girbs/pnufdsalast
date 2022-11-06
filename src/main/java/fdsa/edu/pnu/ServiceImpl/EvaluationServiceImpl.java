/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;


import fdsa.edu.pnu.Config.AWSUtil;
import fdsa.edu.pnu.Model.Evaluation;
import fdsa.edu.pnu.Repository.EvaluationDAO;
import fdsa.edu.pnu.Service.IEvaluationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
@Data
@Service
public class EvaluationServiceImpl implements IEvaluationService {
    @Autowired
    private EvaluationDAO evaluationDAO;
    @Autowired
    private AWSUtil awsUtil;

    @Override
    public List<Evaluation> findAll() {
        return evaluationDAO.findAll();
    }

    @Override
    public Optional<Evaluation> findById(Integer id) {
        return evaluationDAO.findById(id);
    }

    @Override
    public Evaluation save(Evaluation evaluationOrdinaire, MultipartFile file) {
        String fileUrl = awsUtil.uploadFile(file);
        evaluationOrdinaire.setLienFichier (fileUrl);
        return evaluationDAO.save(evaluationOrdinaire);
    }

    @Override
    public void delete(Integer id) {
        evaluationDAO.deleteById(id);
    }

    @Override
    public List<Evaluation> findEvaluationsByOrganisationExamenId(Integer idOrganisationExamen) {
        return evaluationDAO.findEvaluationsByOrganisationExamenId(idOrganisationExamen);
    }

    @Override
    public List<Evaluation> findListEvaluationByIdCours(Integer IdCours) {
        return evaluationDAO.findByCours(IdCours);
    }
}
