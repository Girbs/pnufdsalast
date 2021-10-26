/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Session;
import fdsa.edu.pnu.ServiceImpl.SessionService;
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
public class SessionController {
    
     @Autowired 
    public SessionService sessionService;
    
    /**
     * Afficher toutes les sessions
     *
     * @return
     */
    @GetMapping(value = "/sessions")
    public List<Session> getAllSession() {
        return (List<Session>) sessionService.getSession();
    }
    
    
    /**
     * Creer une nouvelle Session
     *
     *
     * @param session
     * @return
     */
    @PostMapping("/nouveauSession")
    public Session createSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/Session/(id)")
    public Session getSession(@PathVariable("id") int id) {
        Optional<Session> session = sessionService.getSession(id);
        if ( session.isPresent() ) {
            return session.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer une session
     * @param id 
     */
    
    @DeleteMapping("/supprimerSession")
    public void deleteSession(@PathVariable("id") final int id) {
        sessionService.deleteSession(id);
    }
    
}

