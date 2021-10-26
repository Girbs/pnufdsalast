/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.PlannificationConcoursDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IPlannificationConcoursController {

    @GetMapping(value = "/plannificationConcours/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des PlannificationConcours", notes = "Cette methode permet de chercher et renvoyer la liste des plannificationConcours qui existent "
            + "dans la BDD", responseContainer = "List<PlannificationConcoursDTO>")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La liste des plannification de COncours / Une liste vide")
    })
    List<PlannificationConcoursDTO> findAll();

    @GetMapping(value = "/plannificationConcours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une plannificationConcours par ID", notes = "Cette methode permet de chercher une matiere par son ID", response = PlannificationConcoursDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La plannificationConcours a ete trouve dans la BDD"),
        @ApiResponse(code = 404, message = "Aucun plannificationConcours n'existe dans la BDD avec l'ID fourni")
    })
    PlannificationConcoursDTO findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/plannificationConcours/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une plannificationConcours", notes = "Cette methode permet d'enregistrer ou modifier une plannificationConcours", response = PlannificationConcoursDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "L'objet plannificationConcours cree / modifie"),
        @ApiResponse(code = 400, message = "L'objet plannificationConcours n'est pas valide")
    })
    PlannificationConcoursDTO save(@RequestBody PlannificationConcoursDTO dto);

    @DeleteMapping(value = "/plannificationConcours/supprimer/{id}")
    @ApiOperation(value = "Supprimer une plannificationConcours", notes = "Cette methode permet de supprimer une plannificationConcours par ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Le matiere a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

}
