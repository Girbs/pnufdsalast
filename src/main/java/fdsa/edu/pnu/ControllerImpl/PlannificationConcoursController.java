/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IPlannificationConcoursController;
import fdsa.edu.pnu.DTO.PlannificationConcoursDTO;
import fdsa.edu.pnu.ServiceImpl.PlannificationConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<PlannificationConcoursDTO> findAll() {
        return plannificationConcoursService.findAll();
    }

    @Override
    public PlannificationConcoursDTO findById(Integer id) {
        return plannificationConcoursService.findById(id);
    }

    @Override
    public PlannificationConcoursDTO save(PlannificationConcoursDTO dto) {
        return plannificationConcoursService.save(dto);
    }

    @Override
    public void delete(Integer id) {
        plannificationConcoursService.delete(id);
    }

}
