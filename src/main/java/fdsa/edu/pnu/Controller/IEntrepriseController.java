package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Entreprise;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IEntrepriseController {
    @GetMapping(value = "/entreprise/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des permissions", notes = "Cette methode permet de chercher et renvoyer la liste des permissions qui existent "
            + "dans la BDD", responseContainer = "List<Permission>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<Entreprise> findAll();


    @GetMapping(value = "/entreprise/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un permission par son ID", response = Entreprise.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La permission a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune permission n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Entreprise> findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/entreprise/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un permission", notes = "Cette methode permet d'enregistrer ou modifier une permission", response = Entreprise.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet permission cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet permission n'est pas valide")
    })
    Entreprise save(@RequestBody Entreprise dto);

    @DeleteMapping(value = "/entreprise/supprimer/{id}")
    @ApiOperation(value = "Supprimer une entreprise", notes = "Cette methode permet de supprimer une permission par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L' entreprise a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

}
