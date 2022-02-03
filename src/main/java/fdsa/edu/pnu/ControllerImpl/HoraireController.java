/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHoraireController;
import fdsa.edu.pnu.Model.Horaire;
import fdsa.edu.pnu.ServiceImpl.HoraireServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Richard
 */

@RestController
public class HoraireController implements IHoraireController {
    
    @Autowired
    public HoraireServiceImpl horaireServiceImpl;


    @Override
    public List<Horaire> findAll() {
        return null;
    }

    @Override
    public Optional<Horaire> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Horaire update(Integer id, Horaire horaire) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Horaire save(Horaire horaire) {
        return null;
    }
}
