/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Horaire;
import fdsa.edu.pnu.ServiceImpl.HoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */

@RestController
public class HoraireController {

    @Autowired
    public HoraireService horaireService;

    /**
     * Afficher tous les Horaires
     *
     * @return
     */
    @GetMapping(value = "/horaires")
    public List<Horaire> getAllHoraire() {
        return (List<Horaire>) horaireService.getHoraire();
    }


    /**
     * Creer un nouveau Horaire
     *
     * @param horaire
     * @return
     */
    @PostMapping("/nouveauHoraire")
    public Horaire createHoraire(@RequestBody Horaire horaire) {
        return horaireService.saveHoraire(horaire);
    }

    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */

    @RequestMapping("/Horaire/(id)")
    public Horaire getHoraire(@PathVariable("id") int id) {
        Optional<Horaire> horaire = horaireService.getHoraire(id);
        if (horaire.isPresent()) {
            return horaire.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un Horaire
     *
     * @param id
     */

    @DeleteMapping("/supprimerHoraire")
    public void deleteHoraire(@PathVariable("id") final int id) {
        horaireService.deleteHoraire(id);
    }

}
