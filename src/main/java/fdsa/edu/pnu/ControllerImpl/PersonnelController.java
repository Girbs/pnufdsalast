/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;



import fdsa.edu.pnu.Model.Personnel;
import fdsa.edu.pnu.ServiceImpl.PersonnelService;
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
 * @author Richard
 */
@RestController
public class PersonnelController {
    
    @Autowired 
    public PersonnelService personnelService;
    
    /**
     * Afficher tous les Personnel
     *
     * @return
     */
    @GetMapping(value = "/personnels")
    public List<Personnel> getAllPersonnel() {
        return (List<Personnel>) personnelService.getPersonnel();
    }
    
    
    /**
     * Creer un nouveau Horaire
     *
     *
     * @param personnel
     * @return
     */
    @PostMapping("/nouveauPersonnel")
    public Personnel createHoraire(@RequestBody Personnel personnel) {
        return personnelService.savePersonnel(personnel);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/Personnel/(id)")
    public Personnel getPersonnel(@PathVariable("id") int id) {
        Optional<Personnel> personnel = personnelService.getPersonnel(id);
        if ( personnel.isPresent() ) {
            return personnel.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un Personnel
     * @param id 
     */
    
    @DeleteMapping("/supprimerPersonnel")
    public void deletePersonnel(@PathVariable("id") final int id) {
       personnelService.deletePersonnel(id);
    }
    
  
}
