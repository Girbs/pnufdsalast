package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Model.Session;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/role")
public interface IRoleController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Role", notes = "Cette methode permet de chercher et renvoyer la liste des Session qui existent "
            + "dans la BDD", responseContainer = "List<Role>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Roles / Une liste vide")
    })
    List<Role> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Session par ID", notes = "Cette methode permet de chercher une Session par son ID", response = Role.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Session a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Session n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Role> findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Session", notes = "Cette methode permet d'enregistrer ou modifier une Session", response = Session.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Role cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Role n'est pas valide")
    })
    Role update(@PathVariable("id") Integer id, @RequestBody Role role);

    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer un Role", notes = "Cette methode permet de supprimer un Role par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Role a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Role", notes = "Cette methode permet d'enregistrer ou modifier un Role", response = Role.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Role crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Role n'est pas valide")
    })
    Role save(@RequestBody Role role);
}
