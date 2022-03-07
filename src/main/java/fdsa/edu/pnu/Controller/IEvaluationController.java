package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.EvaluationOrdinaire;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IEvaluationController {

    //  @PreAuthorize("hasAnyRole( 'lireConcours')")
    @GetMapping(value = "/evaluation/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des evaluations", notes = "Cette methode permet de chercher et renvoyer la liste des evaluation qui existent "
            + "dans la BDD", responseContainer = "List<EvaluationOrdinaire>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des evaluation / Une liste vide")
    })
    List<EvaluationOrdinaire> findAll();

    // @PreAuthorize("hasAnyRole('lireConcours')")
    @GetMapping(value = "/evaluation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un cours par ID", notes = "Cette methode permet de chercher un cours par son ID", response = EvaluationOrdinaire.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Cours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun cours n'existe dans la BDD avec l'ID fourni")
    })
    Optional<EvaluationOrdinaire> findById(@PathVariable("id") Integer id);


    // @PreAuthorize("hasAnyRole('modifierConcours')")
    @PutMapping(value = "/evaluationOrdinaire/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un evaluationOrdinaire", notes = "Cette methode permet d'enregistrer ou modifier un evaluationOrdinaire", response = EvaluationOrdinaire.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le evaluationOrdinaire cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet evaluationOrdinaire n'est pas valide")
    })
    EvaluationOrdinaire update(@PathVariable("id") Integer id, @RequestBody EvaluationOrdinaire evaluationOrdinaire);


    // @PreAuthorize("hasAnyRole('supplrimerConcours')")
    @DeleteMapping(value = "/evaluation/supprimer/{id}")
    @ApiOperation(value = "Supprimer un cours", notes = "Cette methode permet de supprimer un cours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le cours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    // @PreAuthorize("hasAnyRole('creerConcours')")
    @PostMapping(value = "/evaluationOrdinaire/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un evaluationOrdinaire", notes = "Cette methode permet d'enregistrer ou modifier un evaluationOrdinaire", response = EvaluationOrdinaire.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet l' evaluationOrdinaire cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet evaluationOrdinaire n'est pas valide")
    })
    EvaluationOrdinaire save(@RequestBody EvaluationOrdinaire evaluationOrdinaire);

}
