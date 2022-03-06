package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Session;
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
    public List<Session> findAll() {
        return semestreDAO.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return semestreDAO.findById(id);
    }

    @Override
    public Session save(Session session) {
        return semestreDAO.save(session);
    }

    @Override
    public Session update(Integer id, Session session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        semestreDAO.deleteById(id);
    }
}
