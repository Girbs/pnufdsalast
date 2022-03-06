package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICurriculumController;
import fdsa.edu.pnu.Model.CoursProgramme;
import fdsa.edu.pnu.ServiceImpl.CurriculumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CurriculumControllerImpl implements ICurriculumController {

    @Autowired
    private CurriculumServiceImpl curriculumServiceImpl;

    @Override
    public List<CoursProgramme> findAll() {
        return curriculumServiceImpl.findAll();
    }

    @Override
    public CoursProgramme findById(Integer id) {
        return curriculumServiceImpl.findById(id);
    }

    @Override
    public CoursProgramme update(Integer id, CoursProgramme coursProgramme) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        curriculumServiceImpl.delete(id);
    }

    @Override
    public CoursProgramme save(CoursProgramme coursProgramme) {
        return curriculumServiceImpl.save(coursProgramme);
    }
}
