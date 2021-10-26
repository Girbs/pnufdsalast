/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.DepartementGeographique;
import fdsa.edu.pnu.ServiceImpl.DepartementGeographiqueService;
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
public class DepartementGeographiqueController {
        @Autowired
public DepartementGeographiqueService departementGeographiqueService;
     /**
     * Afficher tous les Departements
     *
     * @return
     */
    @GetMapping(value = "/departementsGeographiques")
    public List<DepartementGeographique> getAllDepartementGeographique() {
        return (List<DepartementGeographique>) departementGeographiqueService.getDepartementGeographique();
    }

    
    /**
     * Creer nouveau Departement
     *
     * @param departementGeographique  
     * @return
     */
    @PostMapping("/nouveauDepartementGeographique")
    public DepartementGeographique createDepartementGeographique(@RequestBody DepartementGeographique departementGeographique) {
        return departementGeographiqueService.saveDepartementGeographique(departementGeographique);
    }

    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/DepartementGeographique/{id}")
    public DepartementGeographique getDepartementGeographique(@PathVariable("id") int id) {
        Optional<DepartementGeographique> departementGeographique = departementGeographiqueService.getdepartementGeographique(id);
        if (departementGeographique.isPresent()) {
            return departementGeographique.get();
        } else {
            return null;
        }
    }
    /**
     * Supprimer un Departement
     * @param id 
     */
     @DeleteMapping("/supprimerDepartementGeographique/{id}")
	public void deleteEmployee(@PathVariable("id") final int id) {
		departementGeographiqueService.deleteDepartementGeographique(id);
	}
        
        
        // TO DO modifier un DepartementGeographique
}
