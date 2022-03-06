package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Session;

import java.util.List;
import java.util.Optional;

public interface ISemestreService {

    List<Session> findAll();

    Optional<Session> findById(Integer id);

    Session save(Session session);

    Session update(Integer id, Session session);

    void delete(Integer id);
}
