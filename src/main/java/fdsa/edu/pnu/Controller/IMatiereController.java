/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.MatiereDTO;
import fdsa.edu.pnu.Model.Matiere;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;

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
public interface IMatiereController {

    @GetMapping(value = "/matiere/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des matieres", notes = "Cette methode permet de chercher et renvoyer la liste des matieres qui existent "
            + "dans la BDD", responseContainer = "List<MatiereDTO>")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La liste des matiere / Une liste vide")
    })
    List<Matiere> findAll();

    @GetMapping(value = "/matiere/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une matiere par ID", notes = "Cette methode permet de chercher une matiere par son ID", response = MatiereDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La Matiere   a ete trouve dans la BDD"),
        @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Matiere> findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/matiere/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une matie", notes = "Cette methode permet d'enregistrer ou modifier une matiere", response = MatiereDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "L'objet matiere cree / modifie"),
        @ApiResponse(code = 400, message = "L'objet matiere n'est pas valide")
    })
    MatiereDTO save(@RequestBody MatiereDTO dto);

    @DeleteMapping(value = "/matiere/supprimer/{id}")
    @ApiOperation(value = "Supprimer un matiere", notes = "Cette methode permet de supprimer un matiere par ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Le matiere a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);
}
