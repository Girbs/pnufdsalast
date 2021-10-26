/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Horaire;
import fdsa.edu.pnu.Repository.HoraireDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Richard
 */

@Data
@Service 
public class HoraireService {
    
    @Autowired 
    
     private HoraireDAO horaireDAO;
    
    public Optional<Horaire> getHoraire(final int id) {
        return horaireDAO.findById(id);
    }
    
     public Iterable<Horaire> getHoraire() {
        return horaireDAO.findAll();
    }

    public void deleteHoraire(final int id) {
        horaireDAO.deleteById(id);
    }

    public Horaire saveHoraire(Horaire Horaire) {
        Horaire savedHoraire = horaireDAO.save(Horaire);
        return savedHoraire;
    }
}
