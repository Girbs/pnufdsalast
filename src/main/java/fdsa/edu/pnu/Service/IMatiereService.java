/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.MatiereDTO;
import fdsa.edu.pnu.Model.Matiere;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IMatiereService {

    List<Matiere> findAll();

    Optional<Matiere> findById(Integer id);

    MatiereDTO save(MatiereDTO dto);

    void delete(Integer id);
}
