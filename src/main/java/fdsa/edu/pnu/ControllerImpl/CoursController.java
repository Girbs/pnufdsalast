/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;
import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.ServiceImpl.CoursService;
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
public class CoursController {
    @Autowired
public CoursService coursService;
     /**
     * Afficher tous les cours
     *
     * @return
     */
    @GetMapping(value = "/cours")
    public List<Cours> getAllCours() {
        return (List<Cours>) coursService.getCours();
    }

    
    /**
     * Creer nouveau Cours
     *
     * @param cours  
     * @return
     */
    @PostMapping("/nouveauCours")
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.saveCours(cours);
    }

    
    /**
     * Selectionner par ID
     *
      * @param id
     * @return
     */
   @RequestMapping("/Cours/{id}")
    public Cours getCours(@PathVariable("id") int id) {
        Optional<Cours> cours = coursService.getCours(id);
        if (cours.isPresent()) {
            return cours.get();
        } else {
            return null;
        }
    }
    /**
     * Supprimer un Cours
     * @param id 
     */
     @DeleteMapping("/supprimerCours/{id}")
	public void deleteEmployee(@PathVariable("id") final int id) {
		coursService.deleteCours(id);
	}
        
        
    
}
