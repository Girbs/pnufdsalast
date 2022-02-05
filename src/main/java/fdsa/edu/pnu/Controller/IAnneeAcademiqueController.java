package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.AnneeAcademique;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/anneeAcademique")
public interface IAnneeAcademiqueController {
    @PreAuthorize("hasAnyRole('lireAnneeAcademique')")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Annee Academique", notes = "Cette methode permet de chercher et renvoyer la liste des Annees Academiques qui existent "
            + "dans la BDD", responseContainer = "List<AnneeAcademique>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des concours / Une liste vide")
    })
    List<AnneeAcademique> findAll();

    @PreAuthorize("hasAnyRole('lireAnneeAcademique')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Annee Academique par ID", notes = "Cette methode permet de chercher une Annee Academique par son ID", response = AnneeAcademique.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Annee Academique a ete trouvee dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune Annee Academique n'existe dans la BDD avec l'ID fourni")
    })
    Optional<AnneeAcademique> findById(@PathVariable("id") Integer id);

    @PreAuthorize("hasAnyRole('modifierAnneeAcademique')")
    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un COncours", notes = "Cette methode permet d'enregistrer ou modifier une Annee Academique", response = AnneeAcademique.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet Annee Academique cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet concours n'est pas valide")
    })
    AnneeAcademique update(@PathVariable("id") Integer id, @RequestBody AnneeAcademique anneeAcademique);
    @PreAuthorize("hasAnyRole('supprimerAnneeAcademique')")
    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer un concours", notes = "Cette methode permet de supprimer un concours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le concours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    @PreAuthorize("hasAnyRole('creerAnneeAcademique')")
    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un COncours", notes = "Cette methode permet d'enregistrer ou modifier un concours", response = AnneeAcademique.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le concours créee modifie"),
            @ApiResponse(code = 400, message = "L'objet concours n'est pas valide")
    })
    AnneeAcademique save(@RequestBody AnneeAcademique anneeAcademique);
}
