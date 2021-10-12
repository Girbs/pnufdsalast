/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.TypeRequete;
import fdsa.edu.pnu.Repository.TypeRequeteDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class TypeRequeteService {
    @Autowired
    private TypeRequeteDAO typeRequeteDAO;

    public Optional<TypeRequete> getTypeRequete(final int id) {
        return typeRequeteDAO.findById(id);
    }

    public Iterable<TypeRequete> getTypeRequete() {
        return typeRequeteDAO.findAll();
    }

    public void deleteTypeRequete(final int id) {
        typeRequeteDAO.deleteById(id);
    }

    public TypeRequete saveTypeRequete(TypeRequete TypeRequete) {
        TypeRequete savedTypeRequete = typeRequeteDAO.save(TypeRequete);
        return savedTypeRequete;
    }

}
