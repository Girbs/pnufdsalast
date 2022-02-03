package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Horaire;
import fdsa.edu.pnu.Model.Semestre;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IHoraireController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Semestres", notes = "Cette methode permet de chercher et renvoyer la liste des Horaire qui existent "
            + "dans la BDD", responseContainer = "List<Horaire>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Horaire / Une liste vide")
    })
    List<Horaire> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Semestre par ID", notes = "Cette methode permet de chercher une Semestre par son ID", response = Horaire.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Semestre a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Semestre n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Horaire> findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Semestre", notes = "Cette methode permet d'enregistrer ou modifier une Semestre", response = Semestre.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Semestre cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Semestre n'est pas valide")
    })
    Horaire update(@PathVariable("id") Integer id, @RequestBody Horaire horaire);

    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer un Horaire", notes = "Cette methode permet de supprimer un Horaire par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Horaire a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Horaire", notes = "Cette methode permet d'enregistrer ou modifier un Horaire", response = Horaire.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Horaire crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Horaire n'est pas valide")
    })
    Horaire save(@RequestBody Horaire horaire);
}
