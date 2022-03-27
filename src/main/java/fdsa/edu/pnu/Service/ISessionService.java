package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Session;

import java.util.List;

public interface ISessionService {
    List<Session> findAll();

    Session findById(Integer id);

    Session save(Session session);

    Session update(Integer id, Session session);

    void delete(Integer id);
}
