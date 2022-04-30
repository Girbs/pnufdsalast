package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.CoursEtudiant;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ICoursEtudiantController {

    // @PreAuthorize("hasAnyRole( 'lireConcours')")
    @GetMapping(value = "/coursEtudiant/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Concours", notes = "Cette methode permet de chercher et renvoyer la liste des concours qui existent "
            + "dans la BDD", responseContainer = "List<CoursEtudiant>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des CoursEtudiants / Une liste vide")
    })
    List<CoursEtudiant> findAll();


    // @PreAuthorize("hasAnyRole('lireConcours')")
    @GetMapping(value = "/coursEtudiant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un concours par ID", notes = "Cette methode permet de chercher un concours par son ID", response = CoursEtudiant.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le Concours a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun concours n'existe dans la BDD avec l'ID fourni")
    })
    Optional<CoursEtudiant> findById(@PathVariable("id") Integer id);


    // @PreAuthorize("hasAnyRole('supplrimerConcours')")
    @DeleteMapping(value = "/coursEtudiant/supprimer/{id}")
    @ApiOperation(value = "Supprimer un concours", notes = "Cette methode permet de supprimer un concours par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le concours a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);

    // @PreAuthorize("hasAnyRole('creerConcours')")
    @PostMapping(value = "coursEtudiant/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un COncours", notes = "Cette methode permet d'enregistrer ou modifier un concours", response = CoursEtudiant.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le concours cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet concours n'est pas valide")
    })
    CoursEtudiant save(@RequestBody CoursEtudiant dto);




    @GetMapping(value = "/coursEtudiantByIdEtudiant/{idEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Concours", notes = "Cette methode permet de chercher et renvoyer la liste des cours programmes l'Id De l'etudiant  "
            + "dans la BDD", responseContainer = "List<CoursEtudiant>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des CoursEtudiants / Une liste vide")
    })

    List<CoursEtudiant> FindCoursEtudiantByIdEtudiant( @PathVariable("idEtudiant") Integer idEtudiant);

    @GetMapping(value = "/nombreDeCoursCompletesByEtudiantByProgramme/{idEtudiant}/{idProgramme}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de cours completes par Etudiant par programme", notes = "Cette methode permet de calculer et renvoyer le nombre de cours completé par un etudiant pour un programme quelconque",
           responseContainer = "Integer<Cours completés>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "nombre de cours completé / Une liste vide")
    })
    Integer FindNombreDeCoursCompletedByEtudiantByProgramme(@PathVariable("idEtudiant") Integer idEtudiant , @PathVariable("idProgramme")Integer idProgramme);

    @GetMapping(value = "/findNombreDeCreditCompletedByEtudiantByProgramme/{IdProgramme}/{idEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de credits  completé par etudiant par programme ", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "numbre de credits / Une liste vide")
    })
    public Integer findNombreDeCreditCompletedByEtudiantByProgramme(@PathVariable("IdProgramme") Integer IdProgramme , @PathVariable("idEtudiant")  Integer idEtudiant);



    @GetMapping(value = "/nombreDeCoursAReprendreByEtudiantByProgramme/{idEtudiant}/{idProgramme}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de cours a reprendre par Etudiant par programme", notes = "Cette methode permet de calculer et renvoyer le nombre de cours à reprendre par un etudiant pour un programme quelconque",
            responseContainer = "Integer<Cours Reprendre>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "nombre de cours completé / Une liste vide")
    })
    Integer FindNombreDeCoursAReprendreByEtudiantByProgramme(@PathVariable("idEtudiant") Integer idEtudiant , @PathVariable("idProgramme")Integer idProgramme);



    @GetMapping(value = "/pourcentageDeCreditCompletes/{idEtudiant}/{idProgramme}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le pourcentage de credits completes par Etudiant par programme", notes = "Cette methode permet de calculer et renvoyer le pourcentage de credits complete par un etudiant pour un programme quelconque",
            responseContainer = "Integer<Cours Reprendre>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "nombre de cours completé / Une liste vide")
    })
    double pourcentageDeCreditCompletes(@PathVariable("idEtudiant") Integer idEtudiant , @PathVariable("idProgramme")Integer idProgramme);


    @GetMapping(value = "/findNombreDeCoursRestants/{idEtudiant}/{idProgramme}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de cours restants pour un programme ", notes = "Cette methode permet de calculer et renvoyer le nombre de credits restant",
            responseContainer = "Integer<Cours Reprendre>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "nombre de cours completé / Une liste vide")
    })
    Integer findNombreDeCoursRestants(@PathVariable("idEtudiant") Integer idEtudiant , @PathVariable("idProgramme")Integer idProgramme);





}
