/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Requete;
import fdsa.edu.pnu.ServiceImpl.RequeteService;
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
public class RequeteController {
    
     @Autowired 
    public RequeteService requeteService;
    
    /**
     * Afficher toutes les Requetes
     *
     * @return
     */
    @GetMapping(value = "/requetes")
    public List<Requete> getAllRequete() {
        return (List<Requete>) requeteService.getRequete();
    }
    
    
    /**
     * Creer une nouvelle Requete
     *
     *
     * @param requete
     * @return
     */
    @PostMapping("/nouveauRequete")
    public Requete createRequete(@RequestBody Requete requete) {
        return requeteService.saveRequete(requete);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/requete/{id}")
    public Requete getRequete(@PathVariable("id") int id) {
        Optional<Requete> requete = requeteService.getRequete(id);
        if ( requete.isPresent() ) {
            return requete.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer une requete
     * @param id 
     */
    
    @DeleteMapping("/supprimerRequete")
    public void deleteRequete(@PathVariable("id") final int id) {
        requeteService.deleteRequete(id);
    }
    
}

