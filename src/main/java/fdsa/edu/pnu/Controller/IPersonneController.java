/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.PersonneDTO;
import fdsa.edu.pnu.DTO.PostulantDTO;
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
 * @author gbijou
 */
public interface IPersonneController {
    
    
    @GetMapping(value = "/personne/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des personnes", notes = "Cette methode permet de chercher et renvoyer la liste des personne qui existent "
            + "dans la BDD", responseContainer = "List<PersonneDTO>")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "La liste des personnes / Une liste vide")
    })
    List<PersonneDTO> findAll();

    @GetMapping(value = "/personne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une personne par ID", notes = "Cette methode permet de chercher une personne par son ID", response = PersonneDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
        @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    PostulantDTO findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/nouveaupersonne", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un personne", notes = "Cette methode permet d'enregistrer ou modifier un personne", response = PersonneDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "L'objet personne cree / modifie"),
        @ApiResponse(code = 400, message = "L'objet personne n'est pas valide")
    })
    PersonneDTO save(@RequestBody PersonneDTO dto);

    @DeleteMapping(value = "/personne/supprimer/{id}")
    @ApiOperation(value = "Supprimer un personne", notes = "Cette methode permet de supprimer une personne par ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Le personne a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);
    
}
