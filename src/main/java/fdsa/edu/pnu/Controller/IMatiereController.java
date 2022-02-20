/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.DTO.MatiereDTO;
import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.Model.Postulant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/matiere")
public interface IMatiereController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des matieres", notes = "Cette methode permet de chercher et renvoyer la liste des matieres qui existent "
            + "dans la BDD", responseContainer = "List<MatiereDTO>")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La liste des matiere / Une liste vide")
    })
    List<Matiere> findAll();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une matiere par ID", notes = "Cette methode permet de chercher une matiere par son ID", response = MatiereDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La Matiere   a ete trouve dans la BDD"),
        @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Matiere> findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une matie", notes = "Cette methode permet d'enregistrer ou modifier une matiere", response = MatiereDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "L'objet matiere cree / modifie"),
        @ApiResponse(code = 400, message = "L'objet matiere n'est pas valide")
    })
    Matiere save(@RequestBody Matiere matiere);


    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer un matiere", notes = "Cette methode permet de supprimer un matiere par ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Le matiere a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    @GetMapping("/listeDynamique")
    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des matieres qui existent "
            + "dans la BDD", responseContainer = "List<Matiere>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    APIResponse<Page<Matiere>> getAllMatieressWithPaginationAndSortv1(@RequestParam(required = true)  int offset, @RequestParam(required = true)  int pageSize,
                                                                         @RequestParam(required = true) String field, @RequestParam(required = true)  String searchFiled, String sortDirection );

}
