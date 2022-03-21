package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.OrganisationExamen;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IOrganisationExamenController {

    @GetMapping(value = "/organisationExamen/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des matieres", notes = "Cette methode permet de chercher et renvoyer la liste des matieres qui existent "
            + "dans la BDD", responseContainer = "List<MatiereDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des matiere / Une liste vide")
    })
    List<OrganisationExamen> findAll();



    @GetMapping(value = "/organisationExamen/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une matiere par ID", notes = "Cette methode permet de chercher une matiere par son ID", response = OrganisationExamen.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La Matiere   a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    Optional<OrganisationExamen> findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/organisationExamen/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une matie", notes = "Cette methode permet d'enregistrer ou modifier une matiere", response = OrganisationExamen.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet matiere cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet matiere n'est pas valide")
    })
    OrganisationExamen save(@RequestBody OrganisationExamen organisationExamen);


    @DeleteMapping(value = "/organisationExamen/supprimer/{id}")
    @ApiOperation(value = "Supprimer un matiere", notes = "Cette methode permet de supprimer un matiere par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le matiere a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


}
