/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.DTO.HistoriqueExamenConcoursDTO;
import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IHistoriqueExamenConcoursController {

    @GetMapping(value = "/historiqueExamenConcours/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des historiqueExamenConcours", notes = "Cette methode permet de chercher et renvoyer la liste des historiqueExamenConcours qui existent "
            + "dans la BDD", responseContainer = "List<HistoriqueExamenConcoursDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<HistoriqueExamenConcours> findAll();

    @GetMapping(value = "/resultatExamenConcours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des historiqueExamenConcours", notes = "Cette methode permet de chercher et renvoyer la liste des historiqueExamenConcours qui existent "
            + "dans la BDD", responseContainer = "List<HistoriqueExamenConcoursDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List findResultatExamenConcours(@PathVariable("id") Integer id);


    @GetMapping("/resultatExamenConcoursPageable")
    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des postulant qui existent "
            + "dans la BDD", responseContainer = "List<PostulantDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    APIResponse<Page> findResultatExamenConcoursPageable(@RequestParam(required = true) int offset, @RequestParam(required = true) int pageSize,
                                                         @RequestParam(required = true) String field, @RequestParam(required = true) Integer IdConcours, String sortDirection);


    @GetMapping(value = "/historiqueExamenConcours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une historiqueExamenConcours par ID", notes = "Cette methode permet de chercher une historiqueExamenConcours par son ID", response = HistoriqueExamenConcoursDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La historiqueExamenConcours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun historiqueExamenConcours n'existe dans la BDD avec l'ID fourni")
    })
    HistoriqueExamenConcours findById(@PathVariable("id") Integer id);


    @GetMapping(value = "/historiqueExamenConcoursByPlanificationConcours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une historiqueExamenConcours par ID", notes = "Cette methode permet de chercher une historiqueExamenConcours par son ID", response = HistoriqueExamenConcours.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La historiqueExamenConcours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun historiqueExamenConcours n'existe dans la BDD avec l'ID fourni")
    })
    List<HistoriqueExamenConcours> findResultatExamenConcoursByPlanificationConcours(@PathVariable("id") Integer id);

    @PostMapping(value = "/historiqueExamenConcours/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une plannificationConcours", notes = "Cette methode permet d'enregistrer ou modifier une historiqueExamenConcours", response = HistoriqueExamenConcoursDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet plannificationConcours cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet plannificationConcours n'est pas valide")
    })
    HistoriqueExamenConcours save(@RequestBody HistoriqueExamenConcours dto);

    @DeleteMapping(value = "/historiqueExamenConcours/supprimer/{id}")
    @ApiOperation(value = "Supprimer une historiqueExamenConcours", notes = "Cette methode permet de supprimer une historiqueExamenConcours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le historiqueExamenConcours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

}
