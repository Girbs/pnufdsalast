/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Institution;
import fdsa.edu.pnu.Repository.InstitutionDAO;
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

public class InstitutionService {
    
    @Autowired 
    
     private InstitutionDAO institutionDAO;
    
    public Optional<Institution> getInstitution(final int id) {
        return institutionDAO.findById(id);
    }
    
     public Iterable<Institution> getInstitution() {
        return institutionDAO.findAll();
    }

    public void deleteInstitution(final int id) {
        institutionDAO.deleteById(id);
    }

    public Institution saveInstitution(Institution Institution) {
        Institution savedInstitution = institutionDAO.save(Institution);
        return savedInstitution;
    }
    
}
