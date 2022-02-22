/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Commune;
import fdsa.edu.pnu.Repository.CommuneDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author EstherA
 */
@Data
@Service
public class CommuneService {
    @Autowired
    private CommuneDAO communeDAO;

    public Optional<Commune> getCommune(final int id) {
        return communeDAO.findById(id);
    }

    public Iterable<Commune> getCommune() {
        return communeDAO.findAll();
    }

    public void deleteCommune(final int id) {
        communeDAO.deleteById(id);
    }

    public Commune saveCommune(Commune Commune) {
        Commune savedCommune = communeDAO.save(Commune);
        return savedCommune;
    }
}
