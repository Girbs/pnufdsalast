/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.TypeRequete;
import fdsa.edu.pnu.ServiceImpl.TypeRequeteService;
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
public class TypeRequeteController {
    
     @Autowired 
    public TypeRequeteService typeRequeteService;
    
    /**
     * Afficher tous les TypeRequete
     *
     * @return
     */
    @GetMapping(value = "/typesRequetes")
    public List<TypeRequete> getAllTypeRequete() {
        return (List<TypeRequete>) typeRequeteService.getTypeRequete();
    }
    
    
    /**
     * Creer un nouveau TypeRequete
     *
     *
     * @param typeRequete
     * @return
     */
    @PostMapping("/nouveauTypeRequete")
    public TypeRequete createTypeRequete(@RequestBody TypeRequete typeRequete) {
        return typeRequeteService.saveTypeRequete(typeRequete);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/TypeRequete/(id)")
    public TypeRequete getTypeRequete(@PathVariable("id") int id) {
        Optional<TypeRequete> typeRequete = typeRequeteService.getTypeRequete(id);
        if ( typeRequete.isPresent() ) {
            return typeRequete.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un TypeRequete
     * @param id 
     */
    
    @DeleteMapping("/supprimerTypeRequete")
    public void deleteTypeRequete(@PathVariable("id") final int id) {
        typeRequeteService.deleteTypeRequete(id);
    }
    
}


