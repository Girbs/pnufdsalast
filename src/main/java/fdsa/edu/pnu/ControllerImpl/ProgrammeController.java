/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IProgrammeController;
import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.ServiceImpl.ProgrammeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class ProgrammeController implements IProgrammeController {

    @Autowired
    public ProgrammeServiceImpl programmeServiceImpl;

    @Override
    public List<Programme> findAll() {
        return programmeServiceImpl.findAll();
    }

    @Override
    public Optional<Programme> findById(Integer id) {
        return programmeServiceImpl.findById(id);
    }

    @Override
    public Programme update(Integer id, Programme programme) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        programmeServiceImpl.delete(id);
    }

    @Override
    public Programme save(Programme programme) {
        return programmeServiceImpl.save(programme);
    }
}
