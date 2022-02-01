package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICurriculumController;
import fdsa.edu.pnu.Model.Curriculum;
import fdsa.edu.pnu.ServiceImpl.CurriculumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CurriculumControllerImpl implements ICurriculumController {

    @Autowired
    private CurriculumServiceImpl curriculumServiceImpl;

    @Override
    public List<Curriculum> findAll() {
        return curriculumServiceImpl.findAll();
    }

    @Override
    public Optional<Curriculum> findById(Integer id) {
        return curriculumServiceImpl.findById(id);
    }

    @Override
    public Curriculum update(Integer id, Curriculum curriculum) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        curriculumServiceImpl.delete(id);
    }

    @Override
    public Curriculum save(Curriculum curriculum) {
        return curriculumServiceImpl.save(curriculum);
    }
}
