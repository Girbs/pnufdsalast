/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IEvaluationController;
import fdsa.edu.pnu.Model.EvaluationOrdinaire;
import fdsa.edu.pnu.ServiceImpl.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class EvaluationControllerImpl implements IEvaluationController {
    @Autowired
    public EvaluationServiceImpl evaluationServiceImpl;

    @Override
    public List<EvaluationOrdinaire> findAll() {
        return evaluationServiceImpl.findAll();
    }

    @Override
    public Optional<EvaluationOrdinaire> findById(Integer id) {
        return evaluationServiceImpl.findById(id);
    }

    @Override
    public EvaluationOrdinaire update(Integer id, EvaluationOrdinaire evaluationOrdinaire) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        evaluationServiceImpl.delete(id);
    }

    @Override
    public EvaluationOrdinaire save(EvaluationOrdinaire evaluationOrdinaire) {
        return evaluationServiceImpl.save(evaluationOrdinaire);
    }
}
