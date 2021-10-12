/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Fonction;
import fdsa.edu.pnu.ServiceImpl.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
@RestController
public class FonctionController {
    @Autowired
    public FonctionService fonctionService;

    /**
     * Afficher tous les Fonctions
     *
     * @return
     */
    @GetMapping(value = "/fonctions")
    public List<Fonction> getAllFonction() {
        return (List<Fonction>) fonctionService.getFonction();
    }


    /**
     * Creer nouveau Fonction
     *
     * @param fonction
     * @return
     */
    @PostMapping("/nouveauFonction")
    public Fonction createFonction(@RequestBody Fonction fonction) {
        return fonctionService.saveFonction(fonction);
    }


    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/Fonction/{id}")
    public Fonction getFonction(@PathVariable("id") int id) {
        Optional<Fonction> fonction = fonctionService.getFonction(id);
        if (fonction.isPresent()) {
            return fonction.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer une Fonction
     *
     * @param id
     */
    @DeleteMapping("/supprimerFonction/{id}")
    public void deleteEmployee(@PathVariable("id") final int id) {
        fonctionService.deletefonction(id);
    }
}
