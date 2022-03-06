/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.ChangerMotDePasseUtilisateurDto;
import fdsa.edu.pnu.DTO.UtilisateurDTO;
import fdsa.edu.pnu.Model.Utilisateur;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IUtilisateurController {


    // @PreAuthorize("hasRole('Admin')")
    @GetMapping(value = "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des utilisateurs", notes = "Cette methode permet de chercher et renvoyer la liste des utilisateurs qui existent "
            + "dans la BDD", responseContainer = "List<UtlisateurDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des utilisateurs / Une liste vide")
    })
    List<Utilisateur> findAll();


    @PostMapping(value = "/utilisateur/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Postulant", notes = "Cette methode permet d'enregistrer ou modifier un postulant", response = UtilisateurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet postulant cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet postulant n'est pas valide")
    })
    UtilisateurDTO save(@RequestBody UtilisateurDTO dto);

    @PostMapping(value = "/update/password")
    UtilisateurDTO changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @PostMapping(value = "/utilisateur/motDePasseOublie")
    Utilisateur motDePasseOublie(@RequestBody Utilisateur dto);

    @GetMapping(value = "/utilisateur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Session par ID", notes = "Cette methode permet de chercher une Session par son ID", response = Utilisateur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Session a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Session n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Utilisateur> findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/utilisateur/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Session", notes = "Cette methode permet d'enregistrer ou modifier une Session", response = Utilisateur.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Session cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet Session n'est pas valide")
    })
    Utilisateur update(@PathVariable("id") Integer id, @RequestBody Utilisateur utilisateur);


}
