package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Curriculum;
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
    public List<Curriculum> findAll() {
        return curriculumDAO.findByAllCustomQuery();
    }

    @Override
    public Curriculum findById(Integer id) {
        return curriculumDAO.findCurriculumById(id);
    }

    @Override
    public Curriculum save(Curriculum curriculum) {
        return curriculumDAO.save(curriculum);
    }

    @Override
    public Curriculum update(Integer id, Curriculum curriculum) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        curriculumDAO.deleteById(id);
    }
}
