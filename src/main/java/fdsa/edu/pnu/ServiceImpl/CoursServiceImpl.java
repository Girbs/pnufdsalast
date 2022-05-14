/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Repository.CoursDAO;
import fdsa.edu.pnu.Service.ICoursService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @author EstherA
 */
@Data
@Service
public class CoursServiceImpl implements ICoursService {
    @Autowired
    private CoursDAO coursDAO;


    @Override
    public List<Cours> findAll() {
        return coursDAO.findAll();
    }

    @Override
    public List<Cours> listCoursDisponible() {
        return null;
    }

    @Override
    public List<Cours> ListCoursDiponiblesPourEdudiant(Integer idEtudiant, Integer idProgramme) {
        return coursDAO.ListCoursDiponiblesPourEdudiant(idEtudiant, idProgramme);
    }

    @Override
    public Optional<Cours> findById(Integer id) {
        return coursDAO.findById(id);
    }

    @Override
    public Cours save(Cours cours) {
        return coursDAO.save(cours);
    }

    @Override
    public void delete(Integer id) {
        coursDAO.deleteById(id);
    }

    @Override
    public Cours findCoursProgramByIdCours(Integer id) {
        return coursDAO.findCoursProgramByIdCours(id);
    }
}
