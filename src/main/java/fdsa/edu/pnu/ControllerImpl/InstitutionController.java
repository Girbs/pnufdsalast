/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Entreprise;
import fdsa.edu.pnu.ServiceImpl.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */

@RestController
public class InstitutionController {

    @Autowired
    public InstitutionService institutionService;

    /**
     * Afficher tous les EntrepriseDAO
     *
     * @return
     */
    @GetMapping(value = "/AllInstitutions")
    public List<Entreprise> getAllInstitution() {
        return (List<Entreprise>) institutionService.getInstitution();
    }


    /**
     * Creer un nouveau EntrepriseDAO
     *
     * @param entreprise
     * @return
     */
    @PostMapping("/nouveauInstitution")
    public Entreprise createInstitution(@RequestBody Entreprise entreprise) {
        return institutionService.saveInstitution(entreprise);
    }

    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */

    @RequestMapping("/UneInstitution/{id}")
    public Entreprise getinstitution(@PathVariable("id") int id) {
        Optional<Entreprise> institution = institutionService.getInstitution(id);
        if (institution.isPresent()) {
            return institution.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un institution
     *
     * @param id
     */

    @DeleteMapping("/supprimerInstitution")
    public void deleteInstitution(@PathVariable("id") final int id) {
        institutionService.deleteInstitution(id);
    }


}
