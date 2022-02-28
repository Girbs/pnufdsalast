package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.SessionProgramme;

import java.util.List;

public interface ISessionProgramme {
    List<SessionProgramme> findAll();

    SessionProgramme findById(Integer id);

    SessionProgramme save(SessionProgramme sessionProgramme);

    SessionProgramme update(Integer id, SessionProgramme sessionProgramme);

    void delete(Integer id);
}
