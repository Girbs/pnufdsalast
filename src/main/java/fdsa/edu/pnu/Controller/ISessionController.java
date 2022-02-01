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
    @ApiOperation(value = "Renvoi la liste des Session", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<Session>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Session / Une liste vide")
    })
    List<Session> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Session par ID", notes = "Cette methode permet de chercher une Session par son ID", response = Session.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Session a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Session n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Session> findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Session", notes = "Cette methode permet d'enregistrer ou modifier une Session", response = Session.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Semestre cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Semestre n'est pas valide")
    })
    Session update(@PathVariable("id") Integer id, @RequestBody Session session);

    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer une session ", notes = "Cette methode permet de supprimer un Session par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Session a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Session", notes = "Cette methode permet d'enregistrer ou modifier un Session", response = Session.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Session crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Session n'est pas valide")
    })
    Session save(@RequestBody Session session);

}