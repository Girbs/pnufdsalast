/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Departement;
import fdsa.edu.pnu.ServiceImpl.DepartementService;
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
public class DepartementController {
       @Autowired
public DepartementService departementService;
     /**
     * Afficher tous les Departements
     *
     * @return
     */
    @GetMapping(value = "/departements")
    public List<Departement> getAllDepartement() {
        return (List<Departement>) departementService.getDepartement();
    }

    
    /**
     * Creer nouveau Departement
     *
     * @param departement  
     * @return
     */
    @PostMapping("/nouveauDepartement")
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementService.saveDepartement(departement);
    }

    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/Departement/{id}")
    public Departement getDepartement(@PathVariable("id") int id) {
        Optional<Departement> departement = departementService.getdepartement(id);
        if (departement.isPresent()) {
            return departement.get();
        } else {
            return null;
        }
    }
    /**
     * Supprimer un Departement
     * @param id 
     */
     @DeleteMapping("/supprimerDepartement/{id}")
	public void deleteEmployee(@PathVariable("id") final int id) {
		departementService.deleteDepartement(id);
	}
        
        
        // TO DO modifier un Departement
}
