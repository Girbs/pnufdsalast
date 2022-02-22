/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Publication;
import fdsa.edu.pnu.ServiceImpl.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */

@RestController
public class PublicationController {

    @Autowired
    public PublicationService publicationService;

    /**
     * Afficher toutes les Publications
     *
     * @return
     */
    @GetMapping(value = "/publications")
    public List<Publication> getAllPublication() {
        return (List<Publication>) publicationService.getPublication();
    }


    /**
     * Creer une nouvelle Publication
     *
     * @param publication
     * @return
     */
    @PostMapping("/nouveauPublication")
    public Publication createPublication(@RequestBody Publication publication) {
        return publicationService.savePublication(publication);
    }

    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */

    @RequestMapping("/Publication/(id)")
    public Publication getPublication(@PathVariable("id") int id) {
        Optional<Publication> publication = publicationService.getPublication(id);
        if (publication.isPresent()) {
            return publication.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer une Publication
     *
     * @param id
     */

    @DeleteMapping("/supprimerPublication")
    public void deletePublication(@PathVariable("id") final int id) {
        publicationService.deletePublication(id);
    }

}

