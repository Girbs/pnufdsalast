/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.EvaluationOrdinaire;
import fdsa.edu.pnu.Repository.EvaluationDAO;
import fdsa.edu.pnu.Service.IEvaluationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<EvaluationOrdinaire> findAll() {
        return evaluationDAO.findAll();
    }

    @Override
    public Optional<EvaluationOrdinaire> findById(Integer id) {
        return evaluationDAO.findById(id);
    }

    @Override
    public EvaluationOrdinaire save(EvaluationOrdinaire evaluationOrdinaire) {
        return evaluationDAO.save(evaluationOrdinaire);
    }

    @Override
    public void delete(Integer id) {
        evaluationDAO.deleteById(id);
    }
}
