/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IConcoursController;
import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.ServiceImpl.ConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author EstherA
 */
@RestController
public class ConcoursController implements IConcoursController {

    @Autowired
    public ConcoursService concoursService;

    @Override
    public List<ConcoursDTO> findAll() {
        return concoursService.findAll();
    }

    @Override
    public ConcoursDTO findById(Integer id) {
        return concoursService.findById(id);
    }

    @Override
    public Concours save(Concours concours) {
        return concoursService.save(concours);
    }


    @Override
    public void delete(Integer id) {
        concoursService.delete(id);
    }

    @Override
    public ConcoursDTO update(Integer id, ConcoursDTO dto) {
        return concoursService.update(id, dto);


    }

}
