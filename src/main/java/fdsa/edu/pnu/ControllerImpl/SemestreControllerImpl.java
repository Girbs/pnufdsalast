package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISemestreController;
import fdsa.edu.pnu.Model.Semestre;
import fdsa.edu.pnu.ServiceImpl.SemestreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class SemestreControllerImpl implements ISemestreController {
    @Autowired

    private SemestreServiceImpl semestreServiceImpl;

    @Override
    public List<Semestre> findAll() {
        return semestreServiceImpl.findAll();
    }

    @Override
    public Optional<Semestre> findById(Integer id) {
        return semestreServiceImpl.findById(id);
    }

    @Override
    public Semestre update(Integer id, Semestre semestre) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        semestreServiceImpl.delete(id);
    }

    @Override
    public Semestre save(Semestre semestre) {
        return semestreServiceImpl.save(semestre);
    }
}
