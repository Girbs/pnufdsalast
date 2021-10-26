/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.TypePaiement;
import fdsa.edu.pnu.ServiceImpl.TypePaiementService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jephthé Gédéon
 */

@RestController
public class TypePaiementController {
    
     @Autowired 
    public TypePaiementService typePaiementService;
    
    /**
     * Afficher tous les TypePaiement
     *
     * @return
     */
    @GetMapping(value = "/typesPaiements")
    public List<TypePaiement> getAllTypePaiement() {
        return (List<TypePaiement>) typePaiementService.getTypePaiement();
    }
    
    
    /**
     * Creer un nouveau TypePaiement
     *
     *
     * @param typePaiement
     * @return
     */
    @PostMapping("/nouveauTypePaiement")
    public TypePaiement createTypePaiement(@RequestBody TypePaiement typePaiement) {
        return typePaiementService.saveTypePaiement(typePaiement);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/TypePaiement/(id)")
    public TypePaiement getTypePaiement(@PathVariable("id") int id) {
        Optional<TypePaiement> typePaiement = typePaiementService.getTypePaiement(id);
        if ( typePaiement.isPresent() ) {
            return typePaiement.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un TypePaiement
     * @param id 
     */
    
    @DeleteMapping("/supprimerTypePaiement")
    public void deleteTypePaiement(@PathVariable("id") final int id) {
        typePaiementService.deleteTypePaiement(id);
    }
    
}


