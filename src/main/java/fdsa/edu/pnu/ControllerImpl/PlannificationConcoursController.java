/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IPlannificationConcoursController;
import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.Model.PlannificationConcours;
import fdsa.edu.pnu.ServiceImpl.PlannificationConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Richard
 */
@RestController
public class PlannificationConcoursController implements IPlannificationConcoursController {

    @Autowired
    public PlannificationConcoursService plannificationConcoursService;

    @Override
    public List<PlannificationConcours> findAll() {
        return plannificationConcoursService.findAll();
    }

    @Override
    public List<PlannificationConcours> findPlannificationConcoursByIdConcours(Integer idConcours) {
        return plannificationConcoursService.findPlannificationConcoursByIdConcours(idConcours);
    }


    @Override
    public PlannificationConcours findById(Integer id) {
        return plannificationConcoursService.findById(id);
    }

    @Override
    public PlannificationConcours save(PlannificationConcours dto) {
        return plannificationConcoursService.save(dto);
    }

    @Override
    public void delete(Integer id) {
        plannificationConcoursService.delete(id);
    }

    @Override
    public APIResponse<Page<PlannificationConcours>> getAllPlannificationConcoursWithPaginationAndSortv1(int offset, int pageSize, String field, String searchFiled, String sortDirection) {
        Page<PlannificationConcours> productsWithPagination = plannificationConcoursService.findAllWithPaginationAndSortingv1(offset, pageSize, field, searchFiled, sortDirection);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);

    }

}
