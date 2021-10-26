/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Commune;
import fdsa.edu.pnu.ServiceImpl.CommuneService;
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
 * @author EstherA
 */
@RestController
public class CommuneController {
    @Autowired
public CommuneService communeService;
     /**
     * Afficher tous les commune
     *
     * @return
     */
    @GetMapping(value = "/communes")
    public List<Commune> getAllCommune() {
        return (List<Commune>) communeService.getCommune();
    }

    
    /**
     * Creer nouveau Commune
     *
     * @param commune  
     * @return
     */
    @PostMapping("/nouveauCommune")
    public Commune createCommune(@RequestBody Commune commune) {
        return communeService.saveCommune(commune);
    }

    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/Commune/{id}")
    public Commune getCommune(@PathVariable("id") int id) {
        Optional<Commune> commune = communeService.getCommune(id);
        if (commune.isPresent()) {
            return commune.get();
        } else {
            return null;
        }
    }
    /**
     * Supprimer une Commune
     * @param id 
     */
     @DeleteMapping("/supprimerCommune/{id}")
	public void deleteEmployee(@PathVariable("id") final int id) {
		communeService.deleteCommune(id);
	}
        
        
        // TO DO modifier une Commune
      
}
