package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Session;
import fdsa.edu.pnu.Repository.SessionDAO;
import fdsa.edu.pnu.Service.ISemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements ISemestreService {

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public List<Session> findAll() {
        return sessionDAO.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return sessionDAO.findById(id);
    }

    @Override
    public Session save(Session session) {
        return sessionDAO.save(session);
    }

    @Override
    public Session update(Integer id, Session session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionDAO.deleteById(id);
    }
}
