/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Requete;
import fdsa.edu.pnu.Repository.RequeteDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jephthé Gédéon
 */
@Data
@Service
public class RequeteService {
     @Autowired
    private RequeteDAO requeteDAO;

    public Optional<Requete> getRequete(final int id) {
        return requeteDAO.findById(id);
    }

    public Iterable<Requete> getRequete() {
        return requeteDAO.findAll();
    }

    public void deleteRequete(final int id) {
        requeteDAO.deleteById(id);
    }

    public Requete saveRequete(Requete Requete) {
        Requete savedRequete = requeteDAO.save(Requete);
        return savedRequete;
    }
    
}

