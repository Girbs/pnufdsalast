package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Donation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IDonationController {
    @GetMapping(value = "/donation/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des permissions", notes = "Cette methode permet de chercher et renvoyer la liste des permissions qui existent "
            + "dans la BDD", responseContainer = "List<Permission>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<Donation> findAll();

    @GetMapping(value = "/donation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un permission par son ID", response = Donation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La permission a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune permission n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Donation> findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/donation/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un stage", notes = "Cette methode permet d'enregistrer ou modifier un stage", response = Donation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet stage cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet stage n'est pas valide")
    })
    Donation save(@RequestBody Donation dto);

    @DeleteMapping(value = "/donation/supprimer/{id}")
    @ApiOperation(value = "Supprimer un stage", notes = "Cette methode permet de supprimer un stage par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le stage a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

}
