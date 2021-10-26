/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.TypePaiement;
import fdsa.edu.pnu.Repository.TypePaiementDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jephthé Gédéon
 */
@Data
@Service
public class TypePaiementService {
     @Autowired
    private TypePaiementDAO typePaiementDAO;

    public Optional<TypePaiement> getTypePaiement(final int id) {
        return typePaiementDAO.findById(id);
    }

    public Iterable<TypePaiement> getTypePaiement() {
        return typePaiementDAO.findAll();
    }

    public void deleteTypePaiement(final int id) {
        typePaiementDAO.deleteById(id);
    }

    public TypePaiement saveTypePaiement(TypePaiement TypePaiement) {
        TypePaiement savedTypePaiement = typePaiementDAO.save(TypePaiement);
        return savedTypePaiement;
    }
    
}
