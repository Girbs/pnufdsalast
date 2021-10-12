/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Paiement;
import fdsa.edu.pnu.ServiceImpl.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Ing.Girbson BIJOU
 */
@RestController
public class PaiementController {

    @Autowired
    public PaiementService paiementService;

    /**
     * Afficher tous les paiements
     *
     * @return
     */
    @GetMapping(value = "/paiements")
    public List<Paiement> getAllPaiements() {
        return (List<Paiement>) paiementService.getPaiements();
    }


    /**
     * Creer nouveau Paiement
     *
     * @param employee
     * @return
     */
    @PostMapping("/nouveauPaiement")
    public Paiement createPaiement(@RequestBody Paiement employee) {
        return paiementService.savePaiement(employee);
    }


    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/paiement/{id}")
    public Paiement getPaiement(@PathVariable("id") int id) {
        Optional<Paiement> paiement = paiementService.getPaiement(id);
        if (paiement.isPresent()) {
            return paiement.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un paiement
     *
     * @param id
     */
    @DeleteMapping("/supprimerPaiement/{id}")
    public void deleteEmployee(@PathVariable("id") final int id) {
        paiementService.deletePaiement(id);
    }


    // TO DO modifier un paiement


}
