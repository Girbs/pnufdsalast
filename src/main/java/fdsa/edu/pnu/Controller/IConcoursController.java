/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IConcoursController {

    @GetMapping(value = "/concours/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Concours", notes = "Cette methode permet de chercher et renvoyer la liste des concours qui existent "
            + "dans la BDD", responseContainer = "List<ConcoursDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des concours / Une liste vide")
    })
    List<ConcoursDTO> findAll();

    @GetMapping(value = "/concours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un concours par ID", notes = "Cette methode permet de chercher un concours par son ID", response = ConcoursDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Concours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun concours n'existe dans la BDD avec l'ID fourni")
    })
    ConcoursDTO findById(@PathVariable("id") Integer id);


    @PostMapping(value = "/concours/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un COncours", notes = "Cette methode permet d'enregistrer ou modifier un concours", response = ConcoursDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le concours cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet concours n'est pas valide")
    })
    Concours save(@RequestBody Concours concours);


    @DeleteMapping(value = "/concours/supprimer/{id}")
    @ApiOperation(value = "Supprimer un concours", notes = "Cette methode permet de supprimer un concours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le concours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    @PutMapping(value = "/modifierConcours/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un Concours", notes = "Cette methode permet de modifier un concours", response = ConcoursDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet concours est modifie"),
            @ApiResponse(code = 400, message = "L'objet postulant n'est pas valide")
    })
    ConcoursDTO update( @PathVariable("id") Integer id, @RequestBody ConcoursDTO dto);

}
