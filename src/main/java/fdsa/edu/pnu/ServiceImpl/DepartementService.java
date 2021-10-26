/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Departement;
import fdsa.edu.pnu.Repository.DepartementDAO;
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
public class DepartementService {
        @Autowired
    private DepartementDAO departementDAO;

    public Optional<Departement> getDepartement(final int id) {
        return departementDAO.findById(id);
    }

    public Iterable<Departement> getDepartement() {
        return departementDAO.findAll();
    }

    public void deleteDepartement(final int id) {
        departementDAO.deleteById(id);
    }

    public Departement saveDepartement(Departement Departement) {
        Departement savedDepartement = departementDAO.save(Departement);
        return savedDepartement;
    }

    public Optional<Departement> getdepartement(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
