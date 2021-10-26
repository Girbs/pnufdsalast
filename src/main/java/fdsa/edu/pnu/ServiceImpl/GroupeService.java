/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Groupe;
import fdsa.edu.pnu.Repository.GroupeDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EstherA
 */
@Data
@Service
public class GroupeService {
    @Autowired
    private GroupeDAO groupeDAO;

    /**
     *
     * @param id
     * @return
     */
    public Optional<Groupe> getGroupe(final int id) {
        return groupeDAO.findById(id);
    }

    public Iterable<Groupe> getGroupe() {
        return groupeDAO.findAll();
    }

    public void deleteGroupe(final int id) {
        groupeDAO.deleteById(id);
    }

    public Groupe saveGroupe(Groupe Groupe) {
        Groupe savedGroupe = groupeDAO.save(Groupe);
        return savedGroupe;
    }

    
}
