package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.SessionProgramme;

import java.util.List;
import java.util.Optional;

public interface ISessionService {
    List<SessionProgramme> findAll();

    Optional<SessionProgramme> findById(Integer id);

    SessionProgramme save(SessionProgramme session);

    SessionProgramme update(Integer id, SessionProgramme session);

    void delete(Integer id);
}
