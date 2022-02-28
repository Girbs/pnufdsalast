package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Cours;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ICoursController {

   // @PreAuthorize("hasAnyRole( 'lireCours')")
    @GetMapping(value = "/cours/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Cours", notes = "Cette methode permet de chercher et renvoyer la liste des concours qui existent "
            + "dans la BDD", responseContainer = "List<Cours>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des cours / Une liste vide")
    })
    List<Cours> findAll();

    @PreAuthorize("hasAnyRole('lireCours')")
    @GetMapping(value = "/cours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un cours par ID", notes = "Cette methode permet de chercher un cours par son ID", response = Cours.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Cours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun cours n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Cours> findById(@PathVariable("id") Integer id);


    @PreAuthorize("hasAnyRole('modifierCours')")
    @PutMapping(value = "/cours/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Cours", notes = "Cette methode permet d'enregistrer ou modifier un cours", response = Cours.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le cours cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet cours n'est pas valide")
    })
    Cours update(@PathVariable("id") Integer id, @RequestBody Cours cours);


    @PreAuthorize("hasAnyRole('supprimerCours')")
    @DeleteMapping(value = "/cours/supprimer/{id}")
    @ApiOperation(value = "Supprimer un cours", notes = "Cette methode permet de supprimer un cours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le cours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    @PreAuthorize("hasAnyRole('creerCours')")
    @PostMapping(value = "/cours/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un cours", notes = "Cette methode permet d'enregistrer ou modifier un cours", response = Cours.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le cours cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet cours n'est pas valide")
    })
    Cours save(@RequestBody Cours cours);

}
