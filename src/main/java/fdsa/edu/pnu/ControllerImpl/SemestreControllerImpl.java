package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISemestreController;
import fdsa.edu.pnu.Model.Session;
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
    public List<Session> findAll() {
        return semestreServiceImpl.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return semestreServiceImpl.findById(id);
    }

    @Override
    public Session update(Integer id, Session session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        semestreServiceImpl.delete(id);
    }

    @Override
    public Session save(Session session) {
        return semestreServiceImpl.save(session);
    }
}
