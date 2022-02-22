package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Semestre;
import fdsa.edu.pnu.Repository.SemestreDAO;
import fdsa.edu.pnu.Service.ISemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreServiceImpl implements ISemestreService {

    @Autowired
    private SemestreDAO semestreDAO;

    @Override
    public List<Semestre> findAll() {
        return semestreDAO.findAll();
    }

    @Override
    public Optional<Semestre> findById(Integer id) {
        return semestreDAO.findById(id);
    }

    @Override
    public Semestre save(Semestre semestre) {
        return semestreDAO.save(semestre);
    }

    @Override
    public Semestre update(Integer id, Semestre semestre) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        semestreDAO.deleteById(id);
    }
}
