/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;


import fdsa.edu.pnu.Model.PaiementSession;
import fdsa.edu.pnu.Repository.PaiementSessionDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Richard
 */

@Data
@Service

public class PaiementSessionService {

    @Autowired

    private PaiementSessionDAO paiementSessionDAO;

    public Optional<PaiementSession> getPaiementSession(final int id) {
        return paiementSessionDAO.findById(id);
    }

    public Iterable<PaiementSession> getPaiementSession() {
        return paiementSessionDAO.findAll();
    }

    public void deletePaiementSession(final int id) {
        paiementSessionDAO.deleteById(id);
    }

    public PaiementSession savePaiementSession(PaiementSession PaiementSession) {
        PaiementSession savedPaiementSession = paiementSessionDAO.save(PaiementSession);
        return savedPaiementSession;
    }
}
