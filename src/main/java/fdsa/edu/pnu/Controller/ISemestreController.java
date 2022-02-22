package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.Semestre;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/semestre")
public interface ISemestreController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Semestres", notes = "Cette methode permet de chercher et renvoyer la liste des Semestre qui existent "
            + "dans la BDD", responseContainer = "List<Semestre>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des Semestre / Une liste vide")
    })
    List<Semestre> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Semestre par ID", notes = "Cette methode permet de chercher une Semestre par son ID", response = Semestre.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Semestre a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Semestre n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Semestre> findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Semestre", notes = "Cette methode permet d'enregistrer ou modifier une Semestre", response = Semestre.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Semestre cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Semestre n'est pas valide")
    })
    Semestre update(@PathVariable("id") Integer id, @RequestBody Semestre semestre);

    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer unSemestre", notes = "Cette methode permet de supprimer un Semestre par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Semestre a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Semestre", notes = "Cette methode permet d'enregistrer ou modifier un Semestre", response = Semestre.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Semestre crée modifie"),
            @ApiResponse(code = 400, message = "L'objet Semestre n'est pas valide")
    })
    Semestre save(@RequestBody Semestre semestre);
}
