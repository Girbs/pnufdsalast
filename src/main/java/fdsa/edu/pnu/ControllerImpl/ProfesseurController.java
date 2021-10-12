/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Professeur;
import fdsa.edu.pnu.ServiceImpl.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */
@RestController
public class ProfesseurController {

    @Autowired
    public ProfesseurService professeurService;

    /**
     * Afficher tous les Professeur
     *
     * @return
     */
    @GetMapping(value = "/professeurs")
    public List<Professeur> getAllProfesseur() {
        return (List<Professeur>) professeurService.getProfesseur();
    }


    /**
     * Creer un nouveau Professeur
     *
     * @param professeur
     * @return
     */
    @PostMapping("/nouveauProfesseur")
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurService.saveProfesseur(professeur);
    }

    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */

    @RequestMapping("/Professeur/(id)")
    public Professeur getProfesseur(@PathVariable("id") int id) {
        Optional<Professeur> professeur = professeurService.getProfesseur(id);
        if (professeur.isPresent()) {
            return professeur.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un Professeur
     *
     * @param id
     */

    @DeleteMapping("/supprimerProfesseur")
    public void deleteProfesseur(@PathVariable("id") final int id) {
        professeurService.deleteProfesseur(id);
    }


}
