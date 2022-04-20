package fdsa.edu.pnu.Controller;

import fdsa.edu.pnu.Model.CoursProgramme;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/coursProgramme")
public interface ICoursProgrammeController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des CoursProgramme", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des CoursProgramme / Une liste vide")
    })
    List<CoursProgramme> findAll();


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un CoursProgramme par ID", notes = "Cette methode permet de chercher une SessionProgramme par son ID", response = CoursProgramme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le CoursProgramme a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun CoursProgramme n'existe dans la BDD avec l'ID fourni")
    })
    CoursProgramme findById(@PathVariable("id") Integer id);


    @PutMapping(value = "/modifier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un CoursProgramme", notes = "Cette methode permet d'enregistrer ou modifier une CoursProgramme", response = CoursProgramme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet CoursProgramme cr / modifie"),
            @ApiResponse(code = 400, message = "L'objet CoursProgramme n'est pas valide")
    })
    CoursProgramme update(@PathVariable("id") Integer id, @RequestBody CoursProgramme coursProgramme);

    @DeleteMapping(value = "/supprimer/{id}")
    @ApiOperation(value = "Supprimer une session ", notes = "Cette methode permet de supprimer un SessionProgramme par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le SessionProgramme a ete supprime")
    })
    void delete(@PathVariable("id") Integer id);


    @PostMapping(value = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un CoursProgramme", notes = "Cette methode permet d'enregistrer ou modifier un CoursProgramme", response = CoursProgramme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet le CoursProgramme crée modifie"),
            @ApiResponse(code = 400, message = "L'objet CoursProgramme n'est pas valide")
    })
    CoursProgramme save(@RequestBody CoursProgramme coursProgramme);



    @GetMapping(value = "/findBySessionId/{idSession}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des CoursProgramme", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des CoursProgramme / Une liste vide")
    })
    List<CoursProgramme> FindCoursProgrammeBySessionId(@PathVariable("idSession") Integer idSession);



    @GetMapping(value = "/findListCoursProgrammeByEtudiant/{IdProgramme}/{idEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des CoursProgramme par Etudiant", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des CoursProgramme / Une liste vide")
    })
    List <CoursProgramme>  FindListCoursProgrammeByEtudiant ( @PathVariable("IdProgramme") Integer IdProgramme,  @PathVariable("idEtudiant") Integer idEtudiant);


    @GetMapping(value = "/findNombredeCreditsByProgramme/{IdProgramme}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de credits par programme ", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "numbre de credits / Une liste vide")
    })
    public Integer findNombredeCreditsByProgramme(@PathVariable("IdProgramme") Integer IdProgramme);

    @GetMapping(value = "/findNombreDeCreditCompletedByEtudiantByProgramme/{IdProgramme}/{idEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi le nombre de credits  completé par etudiant par programme ", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "numbre de credits / Une liste vide")
    })
    public Integer findNombreDeCreditCompletedByEtudiantByProgramme(@PathVariable("IdProgramme") Integer IdProgramme , @PathVariable("idEtudiant")  Integer idEtudiant);



    @GetMapping(value = "/findListCoursAndPrerequisByIdProgram/{idProgramme}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie le cursus par programme", notes = "Cette methode permet de chercher et renvoyer la liste des Sessions qui existent "
            + "dans la BDD", responseContainer = "List<CoursProgramme>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des CoursProgramme / Une liste vide")
    })
    public List<CoursProgramme> ListCoursAndPrerequisByIdProgram(@PathVariable("idProgramme") Integer idProgramme);
}
