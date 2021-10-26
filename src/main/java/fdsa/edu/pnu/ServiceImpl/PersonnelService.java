/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Personnel;
import fdsa.edu.pnu.Repository.PersonnelDAO;
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


public class PersonnelService {
    
    @Autowired
     private PersonnelDAO personnelDAO;
    
    public Optional<Personnel> getPersonnel(final int id) {
        return personnelDAO.findById(id);
    }
    
     public Iterable<Personnel> getPersonnel() {
        return personnelDAO.findAll();
    }

    public void deletePersonnel(final int id) {
       personnelDAO.deleteById(id);
    }

    public Personnel savePersonnel(Personnel Personnel) {
        Personnel savedPersonnel = personnelDAO.save(Personnel);
        return savedPersonnel;
    }
    
    
    
    
}
