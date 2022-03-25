package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.HistoriqueEvaluation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenController {


    //  @PreAuthorize("hasAnyRole( 'lireConcours')")
    @GetMapping(value = "/historiqueEvaluation/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des evaluations", notes = "Cette methode permet de chercher et renvoyer la liste des evaluation qui existent "
            + "dans la BDD", responseContainer = "List<EvaluationOrdinaire>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des evaluation / Une liste vide")
    })
    List<HistoriqueEvaluation> findAll();


    @GetMapping(value = "/findHistoriqueEvaluationByIdEvaluation/{IdEvaluation}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des evaluations", notes = "Cette methode permet de chercher et renvoyer la liste des evaluation qui existent "
            + "dans la BDD", responseContainer = "List<HistoriqueEvaluation>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des evaluation / Une liste vide")
    })
    List<HistoriqueEvaluation> findHistoriqueEvaluationByIdEvaluation (@PathVariable("IdEvaluation") Integer IdEvaluation);

    @GetMapping(value = "/findHistoriqueEvaluationByIdCoursEtudiant/{IdCoursEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des evaluations", notes = "Cette methode permet de chercher et renvoyer la liste des evaluation qui existent "
            + "dans la BDD", responseContainer = "List<HistoriqueEvaluation>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des evaluation / Une liste vide")
    })

   List<HistoriqueEvaluation> findHistoriqueEvaluationByIdCoursEtudiant(@PathVariable("IdCoursEtudiant")Integer IdCoursEtudiant);


    // @PreAuthorize("hasAnyRole('lireConcours')")
    @GetMapping(value = "/historiqueEvaluation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un cours par ID", notes = "Cette methode permet de chercher un cours par son ID", response = HistoriqueEvaluation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Cours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun cours n'existe dans la BDD avec l'ID fourni")
    })
    Optional<HistoriqueEvaluation> findById(@PathVariable("id") Integer id);

    @GetMapping(value = "/historiqueExamenEtudiant/{idEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un cours par ID", notes = "Cette methode permet de chercher un cours par son ID", response = HistoriqueEvaluation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Cours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun cours n'existe dans la BDD avec l'ID fourni")
    })
   double note(@PathVariable("idEtudiant") Integer id);


    // @PreAuthorize("hasAnyRole('modifierConcours')")
    @PutMapping(value = "/historiqueEvaluation/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un evaluation", notes = "Cette methode permet d'enregistrer ou modifier un evaluation", response = HistoriqueEvaluation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le evaluation cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet evaluation n'est pas valide")
    })
    HistoriqueEvaluation update(@PathVariable("id") Integer id, @RequestBody HistoriqueEvaluation historiqueEvaluation);


    // @PreAuthorize("hasAnyRole('supplrimerConcours')")
    @DeleteMapping(value = "/historiqueEvaluation/supprimer/{id}")
    @ApiOperation(value = "Supprimer un cours", notes = "Cette methode permet de supprimer un cours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le cours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    // @PreAuthorize("hasAnyRole('creerConcours')")
    @PostMapping(value = "/historiqueEvaluation/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un evaluation", notes = "Cette methode permet d'enregistrer ou modifier un evaluation", response = HistoriqueEvaluation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet l' evaluation cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet evaluation n'est pas valide")
    })
    HistoriqueEvaluation save(@RequestBody HistoriqueEvaluation historiqueEvaluation);

}
