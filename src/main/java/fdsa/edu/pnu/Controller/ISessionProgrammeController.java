package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.Model.SessionProgramme;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ISessionProgrammeController {
    @GetMapping(value = "/sessionProgramme/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Programmes", notes = "Cette methode permet de chercher et renvoyer la liste des Programmes qui existent "
            + "dans la BDD", responseContainer = "List<Programme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Programmes / Une liste vide")
    })
    List<SessionProgramme> findAll();


    @GetMapping(value = "/sessionProgramme/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une SessionProgramme par ID", notes = "Cette methode permet de chercher un Programme par son ID", response = Programme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La SessionProgramme a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune SessionProgramme n'existe dans la BDD avec l'ID fourni")
    })
    SessionProgramme findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/sessionProgramme/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une SessionProgramme", notes = "Cette methode permet d'enregistrer ou modifier un Programme", response = Programme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Programme cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Programme n'est pas valide")
    })
    SessionProgramme update(@PathVariable("id") Integer id, @RequestBody SessionProgramme sessionProgramme);

    @DeleteMapping(value = "/sessionProgramme/supprimer/{id}")
    @ApiOperation(value = "Supprimer une SessionProgramme", notes = "Cette methode permet de supprimer un Programme par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Programme a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/sessionProgramme/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une SessionProgramme", notes = "Cette methode permet d'enregistrer ou modifier un Programme", response = SessionProgramme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Programme crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Programme n'est pas valide")
    })
    SessionProgramme save(@RequestBody SessionProgramme sessionProgramme);
}
