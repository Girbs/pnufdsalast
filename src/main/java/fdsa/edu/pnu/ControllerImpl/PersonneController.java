/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IPersonneController;
import fdsa.edu.pnu.DTO.PersonneDTO;
import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Model.Personne;
import fdsa.edu.pnu.ServiceImpl.PersonneService;
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
public class PersonneController implements IPersonneController {
    
     @Autowired 
    public PersonneService personneService;
    
    /**
     * Afficher tous les Personne
     *
     * @return
     */
     
//    @GetMapping(value = "/personne")
//    public List<Personne> getAllPersonne() {
//        return (List<Personne>) personneService.getPersonne();
//    }
//    
    
    /**
     * Creer un nouveau Personne
     *
     *
     * @param personne
     * @return
     */
    @PostMapping("/nouveauPersonne")
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneService.saveHoraire(personne);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/personne/{id}")
    public Personne getPersonne(@PathVariable("id") int id) {
        Optional<Personne> personne = personneService.getPersonne(id);
        if ( personne.isPresent() ) {
            return personne.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un Personne
     * @param id 
     */
    
    @DeleteMapping("/supprimerPersonne")
    public void deletePersonne(@PathVariable("id") final int id) {
        personneService.deletePersonne(id);
    }

    @Override
    public List<PersonneDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PostulantDTO findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonneDTO save(PersonneDTO dto) {
        return personneService.save(dto); 
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
