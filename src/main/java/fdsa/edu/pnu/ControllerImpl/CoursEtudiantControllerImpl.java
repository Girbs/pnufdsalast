package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICoursEtudiantController;
import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.ServiceImpl.CoursEtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursEtudiantControllerImpl implements ICoursEtudiantController {

    @Autowired
    private CoursEtudiantServiceImpl coursEtudiantServiceImpl;

    @Override
    public List<CoursEtudiant> findAll() {
        return coursEtudiantServiceImpl.findAll();
    }

    @Override
    public Optional<CoursEtudiant> findById(Integer id) {
        return coursEtudiantServiceImpl.findById(id);
    }

    @Override
    public void delete(Integer id) {
        coursEtudiantServiceImpl.delete(id);
    }

    @Override
    public CoursEtudiant save(CoursEtudiant dto) {
        return coursEtudiantServiceImpl.save(dto);
    }
}
