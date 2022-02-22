/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Etudiant;

import java.util.List;
import java.util.Optional;

/**
 * @author gbijou
 */
public interface IEtudiantService {

    List<Etudiant> findAll();

    Optional<Etudiant> findById(Integer id);

    Etudiant save(Etudiant dto);

    void delete(Integer id);
}
