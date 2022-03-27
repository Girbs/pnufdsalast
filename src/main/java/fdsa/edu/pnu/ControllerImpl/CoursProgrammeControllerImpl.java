package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICoursProgrammeController;
import fdsa.edu.pnu.Model.CoursProgramme;
import fdsa.edu.pnu.ServiceImpl.CoursProgrammeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursProgrammeControllerImpl implements ICoursProgrammeController {

    @Autowired
    private CoursProgrammeServiceImpl coursProgrammeServiceImpl;

    @Override
    public List<CoursProgramme> findAll() {
        return coursProgrammeServiceImpl.findAll();
    }

    @Override
    public CoursProgramme findById(Integer id) {
        return coursProgrammeServiceImpl.findById(id);
    }

    @Override
    public CoursProgramme update(Integer id, CoursProgramme coursProgramme) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        coursProgrammeServiceImpl.delete(id);
    }

    @Override
    public CoursProgramme save(CoursProgramme coursProgramme) {
        return coursProgrammeServiceImpl.save(coursProgramme);
    }
}
