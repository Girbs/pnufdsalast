/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.PlannificationConcours;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IPlannificationConcoursService {

    List<PlannificationConcours> findAll();

    PlannificationConcours findById(Integer id);

    PlannificationConcours save(PlannificationConcours dto);

    //    public PlannificationConcours update(Concours concours);
    Page<PlannificationConcours> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection);

    List<PlannificationConcours> findPlannificationConcoursByIdConcours(Integer IdConcours);
    void delete(Integer id);
}
