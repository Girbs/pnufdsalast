/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Groupe;
import fdsa.edu.pnu.ServiceImpl.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
@RestController
public class GroupeController {
    @Autowired
    public GroupeService groupeService;

    /**
     * Afficher tous les Groupes
     *
     * @return
     */
    @GetMapping(value = "/groupes")
    public List<Groupe> getAllGroupe() {
        return (List<Groupe>) groupeService.getGroupe();
    }


    /**
     * Creer nouveau Groupe
     *
     * @param groupe
     * @return
     */
    @PostMapping("/nouveauGroupe")
    public Groupe createGroupe(@RequestBody Groupe groupe) {
        return groupeService.saveGroupe(groupe);
    }


    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/Groupe/{id}")
    public Groupe getGroupe(@PathVariable("id") int id) {
        Optional<Groupe> groupe = groupeService.getGroupe(id);
        if (groupe.isPresent()) {
            return groupe.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un Groupe
     *
     * @param id
     */
    @DeleteMapping("/supprimerGroupe/{id}")
    public void deleteEmployee(@PathVariable("id") final int id) {
        groupeService.deleteGroupe(id);
    }


    // TO DO modifier un Groupe

}
