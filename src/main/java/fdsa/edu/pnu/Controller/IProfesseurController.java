package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.DTO.ProfesseurDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProfesseurController {
    @GetMapping(value = "/professeur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Professeur", notes = "Cette methode permet de chercher et renvoyer la liste des professeur qui existent "
            + "dans la BDD", responseContainer = "List<ProfesseurDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<ProfesseurDTO> findAll();

    @GetMapping(value = "/professeur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un postulant par son ID", response = PostulantDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ProfesseurDTO findById(@PathVariable("id") Integer id);

    @PostMapping(value = "/professeur/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un Postulant", notes = "Cette methode permet d'enregistrer ou modifier un postulant", response = PostulantDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet postulant cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet postulant n'est pas valide")
    })
    ProfesseurDTO save(@RequestBody ProfesseurDTO dto);

    @DeleteMapping(value = "/professeur/supprimer/{id}")
    @ApiOperation(value = "Supprimer un postulant", notes = "Cette methode permet de supprimer un postulant par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le professeur a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifierProfesseur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modifier un Postulant", notes = "Cette methode permet de modifier un professeur", response = ProfesseurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet professeur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet professeur n'est pas valide")
    })
    ProfesseurDTO update( @PathVariable("id") Integer id, @RequestBody ProfesseurDTO dto);

}
