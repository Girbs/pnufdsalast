/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.ServiceImpl.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */

@RestController
public class ProgrammeController {

    @Autowired
    public ProgrammeService programmeService;

    /**
     * Afficher tous les Programmes
     *
     * @return
     */
    @GetMapping(value = "/programmes")
    public List<Programme> getAllProgramme() {
        return (List<Programme>) programmeService.getProgramme();
    }


    /**
     * Creer un nouveau Programme
     *
     * @param programme
     * @return
     */
    @PostMapping("/nouveauProgramme")
    public Programme createProgramme(@RequestBody Programme programme) {
        return programmeService.saveProgramme(programme);
    }

    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */

    @RequestMapping("/Programme/(id)")
    public Programme getProgramme(@PathVariable("id") int id) {
        Optional<Programme> programme = programmeService.getProgramme(id);
        if (programme.isPresent()) {
            return programme.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un Horaire
     *
     * @param id
     */

    @DeleteMapping("/supprimerProgramme")
    public void deleteProgramme(@PathVariable("id") final int id) {
        programmeService.deleteProgramme(id);
    }

}
