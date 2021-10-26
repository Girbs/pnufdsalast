/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.PaiementSession;
import fdsa.edu.pnu.ServiceImpl.PaiementSessionService;
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
public class PaiementSessionController {
    
    
     @Autowired 
    public PaiementSessionService paiementSessionService;
    
    /**
     * Afficher tous les PaiementSession
     *
     * @return
     */
    @GetMapping(value = "/paiementSessions")
    public List<PaiementSession> getAllPaiementSession() {
        return (List<PaiementSession>) paiementSessionService.getPaiementSession();
    }
    
    
    /**
     * Creer un nouveau PaiementSession
     *
     *
     * @param paiementSession
     * @return
     */
    @PostMapping("/nouveauPaiementSession")
    public PaiementSession createPaiementSession(@RequestBody PaiementSession paiementSession) {
        return paiementSessionService.savePaiementSession(paiementSession);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/PaiementSession/(id)")
    public PaiementSession getPaiementSession(@PathVariable("id") int id) {
        Optional<PaiementSession> paiementSession = paiementSessionService.getPaiementSession(id);
        if ( paiementSession.isPresent() ) {
            return paiementSession.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un PaiementSession
     * @param id 
     */
    
    @DeleteMapping("/supprimerPaiementSession")
    public void deletePaiementSession(@PathVariable("id") final int id) {
        paiementSessionService.deletePaiementSession(id);
    }
    
    
}
