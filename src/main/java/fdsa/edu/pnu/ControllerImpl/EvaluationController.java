/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Evaluation;
import fdsa.edu.pnu.ServiceImpl.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
@RestController
public class EvaluationController {
    @Autowired
    public EvaluationService evaluationService;

    /**
     * Afficher tous les Evaluations
     *
     * @return
     */
    @GetMapping(value = "/evaluations")
    public List<Evaluation> getAllEvaluation() {
        return (List<Evaluation>) evaluationService.getEvaluation();
    }


    /**
     * Creer nouveau valuation
     *
     * @param evaluation
     * @return
     */
    @PostMapping("/nouveauEvaluation")
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.saveEvaluation(evaluation);
    }


    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/Evaluation/{id}")
    public Evaluation getEvaluation(@PathVariable("id") int id) {
        Optional<Evaluation> evaluation = evaluationService.getEvaluation(id);
        if (evaluation.isPresent()) {
            return evaluation.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer une Evaluation
     *
     * @param id
     */
    @DeleteMapping("/supprimerEvaluation/{id}")
    public void deleteEmployee(@PathVariable("id") final int id) {
        evaluationService.deleteEvaluation(id);
    }


    // TO DO modifier une Evaluation
}
