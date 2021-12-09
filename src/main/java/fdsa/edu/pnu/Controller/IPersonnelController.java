package fdsa.edu.pnu.Controller;


import fdsa.edu.pnu.Model.Personnel;
import fdsa.edu.pnu.Model.Professeur;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IPersonnelController {

    @GetMapping(value = "/personnel/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des personnels", notes = "Cette methode permet de chercher et renvoyer la liste des professeurs qui existent "
            + "dans la BDD", responseContainer = "List<Personnel>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des personnels / Une liste vide")
    })
    List<Personnel> findAll();

    @GetMapping(value = "/personnel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un professeur par son ID", response = Personnel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le personnel a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun personnel n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Personnel> findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/personnel/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un personnel", notes = "Cette methode permet d'enregistrer ou modifier un personnel", response = Personnel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet personnel cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet personnel n'est pas valide")
    })
    Personnel save(@RequestBody  Personnel personnel);

    @DeleteMapping(value = "/personnel/supprimer/{id}")
    @ApiOperation(value = "Supprimer un personnel", notes = "Cette methode permet de supprimer un personnel par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le personnel a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);
}
