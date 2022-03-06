package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.CoursProgramme;
import fdsa.edu.pnu.Repository.CurriculumDAO;
import fdsa.edu.pnu.Service.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements ICurriculumService {

    @Autowired
    private CurriculumDAO curriculumDAO;

    @Override
    public List<CoursProgramme> findAll() {
        return curriculumDAO.findByAllCustomQuery();
    }

    @Override
    public CoursProgramme findById(Integer id) {
        return curriculumDAO.findCurriculumById(id);
    }

    @Override
    public CoursProgramme save(CoursProgramme coursProgramme) {
        return curriculumDAO.save(coursProgramme);
    }

    @Override
    public CoursProgramme update(Integer id, CoursProgramme coursProgramme) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        curriculumDAO.deleteById(id);
    }
}
