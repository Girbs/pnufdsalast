package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Programme;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface IProgrammeController {
    @GetMapping(value = "/programme/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Programmes", notes = "Cette methode permet de chercher et renvoyer la liste des Programmes qui existent "
            + "dans la BDD", responseContainer = "List<Programme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Programmes / Une liste vide")
    })
    List<Programme> findAll();


    @GetMapping(value = "/programme/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un Programme par ID", notes = "Cette methode permet de chercher un Programme par son ID", response = Programme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Programme a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Programme n'existe dans la BDD avec l'ID fourni")
    })
    Programme findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/programme/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Programme", notes = "Cette methode permet d'enregistrer ou modifier un Programme", response = Programme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Programme cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Programme n'est pas valide")
    })
    Programme update(@PathVariable("id") Integer id, @RequestBody Programme programme);

    @DeleteMapping(value = "/programme/supprimer/{id}")
    @ApiOperation(value = "Supprimer un Programme", notes = "Cette methode permet de supprimer un Programme par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Programme a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/programme/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Programme", notes = "Cette methode permet d'enregistrer ou modifier un Programme", response = Programme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Programme crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Programme n'est pas valide")
    })
    Programme save(@RequestBody Programme programme);
}
