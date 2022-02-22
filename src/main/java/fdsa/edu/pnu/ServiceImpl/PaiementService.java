/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Paiement;
import fdsa.edu.pnu.Repository.PaiementDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ing.Girbson BIJOU
 */
@Data
@Service
public class PaiementService {

    @Autowired
    private PaiementDAO paiementDAO;

    public Optional<Paiement> getPaiement(final int id) {
        return paiementDAO.findById(id);
    }

    public Iterable<Paiement> getPaiements() {
        return paiementDAO.findAll();
    }

    public void deletePaiement(final int id) {
        paiementDAO.deleteById(id);
    }

    public Paiement savePaiement(Paiement Paiement) {
        Paiement savedPaiement = paiementDAO.save(Paiement);
        return savedPaiement;
    }

}