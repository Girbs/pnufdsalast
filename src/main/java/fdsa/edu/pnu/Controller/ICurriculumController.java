package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Curriculum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/curriculum")
public interface ICurriculumController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Curriculum", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<Curriculum>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Session / Une liste vide")
    })
    List<Curriculum> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un Curriculum par ID", notes = "Cette methode permet de chercher une Session par son ID", response = Curriculum.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Curriculum a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Curriculum n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Curriculum> findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Curriculum", notes = "Cette methode permet d'enregistrer ou modifier une Curriculum", response = Curriculum.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Curriculum cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Curriculum n'est pas valide")
    })
    Curriculum update(@PathVariable("id") Integer id, @RequestBody Curriculum curriculum);

    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer une session ", notes = "Cette methode permet de supprimer un Session par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Session a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Curriculum", notes = "Cette methode permet d'enregistrer ou modifier un Curriculum", response = Curriculum.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Curriculum crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Curriculum n'est pas valide")
    })
    Curriculum save(@RequestBody Curriculum curriculum);

}
