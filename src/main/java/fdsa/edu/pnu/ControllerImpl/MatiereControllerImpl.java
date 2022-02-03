/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IMatiereController;
import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.ServiceImpl.MatiereServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */
@RestController
public class MatiereControllerImpl implements IMatiereController {

    @Autowired
    public MatiereServiceImpl matiereServiceImpl;

    @Override
    public List<Matiere> findAll() {
        return matiereServiceImpl.findAll();
    }

    @Override
    public Optional<Matiere> findById(Integer id) {
        return matiereServiceImpl.findById(id);
    }


    @Override
    public Matiere save(Matiere matiere) {
        return matiereServiceImpl.save(matiere);
    }

    @Override
    public void delete(Integer id) {
        matiereServiceImpl.delete(id);
    }
}