/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;


import fdsa.edu.pnu.Controller.IPersonnelController;
import fdsa.edu.pnu.Model.Personnel;
import fdsa.edu.pnu.ServiceImpl.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonnelController implements IPersonnelController {

    @Autowired
    public PersonnelService personnelService;


    @Override
    public List<Personnel> findAll() {
        return personnelService.findAll();
    }

    @Override
    public Optional<Personnel> findById(Integer id) {
        return personnelService.findById(id);
    }

    @Override
    public Personnel save(Personnel personnel) {
        return personnelService.save(personnel);
    }

    @Override
    public void delete(Integer id) {

    }
}
