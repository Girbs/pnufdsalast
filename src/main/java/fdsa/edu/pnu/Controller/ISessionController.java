package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Session;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/session")
public interface ISessionController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des SessionProgramme", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<SessionProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des SessionProgramme / Une liste vide")
    })
    List<Session> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une SessionProgramme par ID", notes = "Cette methode permet de chercher une SessionProgramme par son ID", response = Session.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le SessionProgramme a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun SessionProgramme n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Session> findById(@PathVariable("id") Integer id);


    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer une session ", notes = "Cette methode permet de supprimer un SessionProgramme par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le SessionProgramme a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un SessionProgramme", notes = "Cette methode permet d'enregistrer ou modifier un SessionProgramme", response = Session.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le SessionProgramme crée modifie"),
            @ApiResponse(code = 400, message = "L'objet SessionProgramme n'est pas valide")
    })
    Session save(@RequestBody Session session);

}