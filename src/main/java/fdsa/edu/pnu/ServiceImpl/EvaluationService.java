/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Evaluation;
import fdsa.edu.pnu.Repository.EvaluationDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EstherA
 */
@Data
@Service
public class EvaluationService {
     @Autowired
    private EvaluationDAO evaluationDAO;

    public Optional<Evaluation> getEvaluation(final int id) {
        return evaluationDAO.findById(id);
    }

    public Iterable<Evaluation> getEvaluation() {
        return evaluationDAO.findAll();
    }

    public void deleteEvaluation(final int id) {
        evaluationDAO.deleteById(id);
    }

    public Evaluation saveEvaluation(Evaluation Evaluation) {
        Evaluation savedEvaluation = evaluationDAO.save(Evaluation);
        return savedEvaluation;
    }
}
