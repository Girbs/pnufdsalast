/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Matiere;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IMatiereService {

    List<Matiere> findAll();

    List<Matiere> findByAllCustumQuerry();

    Optional<Matiere> findById(Integer id);

    Matiere save(Matiere matiere);

    void delete(Integer id);

    Page<Matiere> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection);
}
