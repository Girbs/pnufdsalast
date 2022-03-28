/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IEvaluationController;
import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Model.Evaluation;
import fdsa.edu.pnu.ServiceImpl.CoursEtudiantServiceImpl;
import fdsa.edu.pnu.ServiceImpl.EvaluationServiceImpl;
import fdsa.edu.pnu.mail.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class EvaluationControllerImpl implements IEvaluationController {
    @Autowired
    public EvaluationServiceImpl evaluationServiceImpl;
    @Autowired
    public CoursEtudiantServiceImpl coursEtudiantServiceImpl;
    @Autowired
    private EmailController emailController;

    @Override
    public List<Evaluation> findAll() {
        return evaluationServiceImpl.findAll();
    }

    @Override
    public Optional<Evaluation> findById(Integer id) {
        return evaluationServiceImpl.findById(id);
    }

    @Override
    public Evaluation update(Integer id, Evaluation evaluationOrdinaire) {
        return null;
    }

    @Override
    public List<Evaluation> findEvaluationsByOrganisationExamenId(Integer idOrganisationExamen) {
        return evaluationServiceImpl.findEvaluationsByOrganisationExamenId(idOrganisationExamen);
    }

    @Override
    public void delete(Integer id) {
        evaluationServiceImpl.delete(id);
    }

    @Override
    public Evaluation save(Evaluation evaluationOrdinaire) {
        Optional<Evaluation> e = evaluationServiceImpl.findById(evaluationOrdinaire.getId());
        String nouveauStatut = evaluationOrdinaire.getStatutResultat();
        if (e.isPresent()) {
            String ancienStatut = e.get().getStatutResultat();
            System.out.println("The is is:" + e.get().getId());

            if(!ancienStatut.equals("Posté") && nouveauStatut.equals("Posté")) {
                List<CoursEtudiant> ce = coursEtudiantServiceImpl.findListCoursEtudiantByIdCours(e.get().getCours().getId());
                System.out.println("Liste  de cours:" + ce);
                for (CoursEtudiant etudiant : ce) {
                    emailController.notificationResultatExamenPostee(etudiant.getEtudiant().getUserName(),
                            e.get().getCours().getCoursProgramme().getMatiere().getDescription(),
                            evaluationOrdinaire.getTypeEvaluation());
                    System.out.println("Email sent to:" + etudiant.getEtudiant().getUserName());
                }
            }
        }
        return evaluationServiceImpl.save(evaluationOrdinaire);
    }
}
