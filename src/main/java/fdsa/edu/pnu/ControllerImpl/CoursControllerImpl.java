/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICoursController;
import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.ServiceImpl.CoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
@RestController
public class CoursControllerImpl implements ICoursController {
    @Autowired
    public CoursServiceImpl coursServiceImpl;


    @Override
    public List<Cours> findAll() {
        return coursServiceImpl.findAll();
    }

    @Override
    public List<Cours> ListCoursDiponiblesPourEdudiant(Integer idEtudiant, Integer idProgramme) {
        return coursServiceImpl.ListCoursDiponiblesPourEdudiant(idEtudiant, idProgramme);
    }

    @Override
    public Optional<Cours> findById(Integer id) {
        return coursServiceImpl.findById(id);
    }

    @Override
    public Cours update(Integer id, Cours cours) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        coursServiceImpl.delete(id);
    }

    @Override
    public Cours save(Cours cours) {
        return coursServiceImpl.save(cours);
    }
}
