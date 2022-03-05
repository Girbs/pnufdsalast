/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Entreprise;
import fdsa.edu.pnu.Repository.InstitutionDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Richard
 */

@Data
@Service

public class InstitutionService {

    @Autowired

    private InstitutionDAO institutionDAO;

    public Optional<Entreprise> getInstitution(final int id) {
        return institutionDAO.findById(id);
    }

    public Iterable<Entreprise> getInstitution() {
        return institutionDAO.findAll();
    }

    public void deleteInstitution(final int id) {
        institutionDAO.deleteById(id);
    }

    public Entreprise saveInstitution(Entreprise Entreprise) {
        Entreprise savedEntreprise = institutionDAO.save(Entreprise);
        return savedEntreprise;
    }

}
