package fdsa.edu.pnu.ControllerImpl;

//package fdsa.edu.PNUFDSA.Controller;
////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
//
//import fdsa.edu.PNUFDSA.Model.Etudiant;
//import fdsa.edu.PNUFDSA.Service.EtudiantService;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author EstherA
// */
//@RestController
//public class EtudiantController {
//   @Autowired
//public EtudiantService etudiantService;
//     /**
//     * Afficher tous les Etudiants
//     *
//     * @return
//     */
////    @GetMapping(value = "/Etudiant")
////    public List<Etudiant> getAllEtudiant() {
////        return (List<Etudiant>) etudiantService.getEtudiant();
////    }
////
////    
////    /**
////     * Creer nouveau Etudiant
////     *  
////     * @param etudiant
////     * @return
////     */
////    @PostMapping("/nouveauEtudiant")
////    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
////        return etudiantService.saveEtudiant(etudiant);
////    }
////
////    
////    /**
////     * Selectionner par ID
////     *
////     * @param id
////     * @return
////     */
////    @RequestMapping("/Etudiant/{id}")
////    public Etudiant getEtudiant(@PathVariable("id") int id) {
////        Optional<Etudiant> etudiant = etudiantService.getEtudiant(id);
////        if (etudiant.isPresent()) {
////            return etudiant.get();
////        } else {
////            return null;
////        }
////    }
////    /**
////     * Supprimer un Etudiant
////     * @param id 
////     */
////     @DeleteMapping("/supprimerEtudiant/{id}")
////	public void deleteEmployee(@PathVariable("id") final int id) {
////		etudiantService.deleteEtudiant(id);
////	}
//        
//        
//        // TO DO modifier un Etudiant
//       
//}
