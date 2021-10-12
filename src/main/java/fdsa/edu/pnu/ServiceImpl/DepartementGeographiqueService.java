/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.DepartementGeographique;
import fdsa.edu.pnu.Repository.DepartementGeographiqueDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author EstherA
 */
@Data
@Service
public class DepartementGeographiqueService {
    @Autowired
    private DepartementGeographiqueDAO departementGeographiqueDAO;

    public Optional<DepartementGeographique> getDepartementGeographique(final int id) {
        return departementGeographiqueDAO.findById(id);
    }

    public Iterable<DepartementGeographique> getDepartementGeographique() {
        return departementGeographiqueDAO.findAll();
    }

    public void deleteDepartementGeographique(final int id) {
        departementGeographiqueDAO.deleteById(id);
    }

    public DepartementGeographique saveDepartementGeographique(DepartementGeographique DepartementGeographique) {
        DepartementGeographique savedDepartementGeographique = departementGeographiqueDAO.save(DepartementGeographique);
        return savedDepartementGeographique;
    }

    public Optional<DepartementGeographique> getdepartementGeographique(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
