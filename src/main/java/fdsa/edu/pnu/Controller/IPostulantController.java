///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fdsa.edu.pnu.Controller;
//
//import fdsa.edu.pnu.DTO.APIResponse;
//import fdsa.edu.pnu.DTO.PostulantDTO;
//import fdsa.edu.pnu.Model.Etudiant;
//import fdsa.edu.pnu.Model.Postulant;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.data.domain.Page;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author Ing.Girbson BIJOU
// */
//public interface IPostulantController {
//
//    @GetMapping(value = "/postulant/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des postulant qui existent "
//            + "dans la BDD", responseContainer = "List<PostulantDTO>")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
//    })
//    List<PostulantDTO> findAll();
//
//    @GetMapping(value = "/postulant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un postulant par son ID", response = PostulantDTO.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
//            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
//    })
//    PostulantDTO findById(@PathVariable("id") Integer id);
//
////    @PostMapping(value = "/postulant/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
////    @ApiOperation(value = "Enregistrer un Postulant", notes = "Cette methode permet d'enregistrer ou modifier un postulant", response = Postulant.class)
////    @ApiResponses(value = {
////            @ApiResponse(code = 200, message = "L'objet postulant cree / modifie"),
////            @ApiResponse(code = 400, message = "L'objet postulant n'est pas valide")
////    })
////    Postulant save(@RequestBody Postulant dto) throws InterruptedException;
////
//    @DeleteMapping(value = "/postulant/supprimer/{id}")
//    @ApiOperation(value = "Supprimer un postulant", notes = "Cette methode permet de supprimer un postulant par ID")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Le postulant a ete supprime")
//    })
//    void delete(@PathVariable("id") Integer id);
//
//
//    @PutMapping(value = "/modifierPostulant/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Modifier un Postulant", notes = "Cette methode permet de modifier un postulant", response = PostulantDTO.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "L'objet postulant cree / modifie"),
//            @ApiResponse(code = 400, message = "L'objet postulant n'est pas valide")
//    })
//    Etudiant update(@PathVariable("id") Integer id, @RequestBody PostulantDTO dto);
//
//
//    @PreAuthorize("hasAnyRole( 'lireConcours')")
//
//    @GetMapping(value = "/postulant", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un postulant par son ID")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
//            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
//    })
//    List<Postulant> findByStatus(@RequestParam(required = false) String status);
//
//
//    @GetMapping("/postulant/all/{offset}/{pageSize}/{field}")
//    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des postulant qui existent "
//            + "dans la BDD", responseContainer = "List<PostulantDTO>")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
//    })
//    APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSort(@RequestParam(required = true)  int offset,
//                                                                       @RequestParam(required = true)int pageSize, @RequestParam(required = true)  String field);
//
//
////THis is the Original Method. It works fine
////    @GetMapping("/postulant/listeDynamique")
////    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des postulant qui existent "
////            + "dans la BDD", responseContainer = "List<PostulantDTO>")
////    @ApiResponses(value = {
////            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
////    })
////    APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSortv1(@RequestParam(required = true)  int offset, @RequestParam(required = true)  int pageSize,
////                                                                         @RequestParam(required = true) String field,@RequestParam(required = true)  String searchFiled );
//
//
//    @GetMapping("/postulant/listeDynamique")
//    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des postulant qui existent "
//            + "dans la BDD", responseContainer = "List<PostulantDTO>")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
//    })
//    APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSortv1(@RequestParam(required = true)  int offset, @RequestParam(required = true)  int pageSize,
//                                                                         @RequestParam(required = true) String field,@RequestParam(required = true)  String searchFiled, String sortDirection );
//
//
//    @GetMapping("/postulantPageWithFilter/{offset}/{pageSize}/{field}/{prenom}")
//    @ApiOperation(value = "Renvoi la liste des postulant", notes = "Cette methode permet de chercher et renvoyer la liste des postulant qui existent "
//            + "dans la BDD", responseContainer = "List<PostulantDTO>")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
//    })
//    APIResponse<Page<Postulant>> findAllWithFilter(@RequestParam(required = true)  int offset, @RequestParam(required = true)  int pageSize,
//                                                   @RequestParam(required = true) String field,@RequestParam(required = true)  String prenom );
//}
