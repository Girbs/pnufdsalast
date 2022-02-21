/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.PlannificationConcours;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IPlannificationConcoursService {

    List<PlannificationConcours> findAll();

    Optional<PlannificationConcours> findById(Integer id);

    PlannificationConcours save(PlannificationConcours dto);

//    public PlannificationConcours update(Concours concours);
Page<PlannificationConcours> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection);

    void delete(Integer id);
}
