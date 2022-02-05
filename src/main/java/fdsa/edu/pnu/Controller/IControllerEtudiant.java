package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Etudiant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/etudiant")
public interface IControllerEtudiant {
    @PreAuthorize("hasAnyRole( 'lireEtudiant')")
    @GetMapping(value = "/concours/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Concours", notes = "Cette methode permet de chercher et renvoyer la liste des concours qui existent "
            + "dans la BDD", responseContainer = "List<ConcoursDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des concours / Une liste vide")
    })
    List<Etudiant> findAll();

    @PreAuthorize("hasAnyRole( 'lireEtudiant')")
    @GetMapping(value = "/concours/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un concours par ID", notes = "Cette methode permet de chercher un concours par son ID", response = Etudiant.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Etudiant a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Etudiant n'existe dans la BDD avec l'ID fourni")
    })
    Optional<Etudiant> findById(@PathVariable("id") Integer id);


    @PreAuthorize("hasAnyRole('modifierEtudiant')")
    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un COncours", notes = "Cette methode permet d'enregistrer ou modifier un concours", response = ConcoursDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le concours cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet concours n'est pas valide")
    })
    Concours update(@PathVariable("id") Integer id, @RequestBody Concours dto);


    @PreAuthorize("hasAnyRole('supplrimerEtudiant')")
    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer un concours", notes = "Cette methode permet de supprimer un concours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le concours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    @PreAuthorize("hasAnyRole('creerEtudiant')")
    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Etudiant", notes = "Cette methode permet d'enregistrer ou modifier un concours", response = Etudiant.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le Etudiant cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet Etudiant n'est pas valide")
    })
    Etudiant save(@RequestBody Etudiant dto);
}
