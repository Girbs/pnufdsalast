package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Evaluation;
import fdsa.edu.pnu.Model.HistoriqueExam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IHistoriqueExamenController {


    //  @PreAuthorize("hasAnyRole( 'lireConcours')")
    @GetMapping(value = "/historiqueExamen/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des evaluations", notes = "Cette methode permet de chercher et renvoyer la liste des evaluation qui existent "
            + "dans la BDD", responseContainer = "List<Evaluation>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des evaluation / Une liste vide")
    })
    List<HistoriqueExam> findAll();

    // @PreAuthorize("hasAnyRole('lireConcours')")
    @GetMapping(value = "/historiqueExamen/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un cours par ID", notes = "Cette methode permet de chercher un cours par son ID", response = Evaluation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Cours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun cours n'existe dans la BDD avec l'ID fourni")
    })
    Optional<HistoriqueExam > findById(@PathVariable("id") Integer id);


    // @PreAuthorize("hasAnyRole('modifierConcours')")
    @PutMapping(value = "/historiqueExamen/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un evaluation", notes = "Cette methode permet d'enregistrer ou modifier un evaluation", response = HistoriqueExam.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le evaluation cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet evaluation n'est pas valide")
    })
    HistoriqueExam update(@PathVariable("id") Integer id, @RequestBody HistoriqueExam historiqueExam);


    // @PreAuthorize("hasAnyRole('supplrimerConcours')")
    @DeleteMapping(value = "/historiqueExamen/supprimer/{id}")
    @ApiOperation(value = "Supprimer un cours", notes = "Cette methode permet de supprimer un cours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le cours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    // @PreAuthorize("hasAnyRole('creerConcours')")
    @PostMapping(value = "/historiqueExamen/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un evaluation", notes = "Cette methode permet d'enregistrer ou modifier un evaluation", response = HistoriqueExam.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet l' evaluation cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet evaluation n'est pas valide")
    })
    HistoriqueExam save(@RequestBody HistoriqueExam historiqueExam);

}