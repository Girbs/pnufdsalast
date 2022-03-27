package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISessionProgrammeController;
import fdsa.edu.pnu.Model.SessionProgramme;
import fdsa.edu.pnu.ServiceImpl.SessionProgrammeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionProgrammeControllerImpl implements ISessionProgrammeController {
    @Autowired
    private SessionProgrammeServiceImpl sessionProgrammeService;

    @Override
    public List<SessionProgramme> findAll() {
        return sessionProgrammeService.findAll();
    }

    @Override
    public List<SessionProgramme> findSessionProgrammeByIdProgramme(Integer idProgramme) {
        return sessionProgrammeService.findSessionProgrammeByIdProgramme(idProgramme);
    }

    @Override
    public SessionProgramme findById(Integer id) {
        return sessionProgrammeService.findById(id);
    }

    @Override
    public SessionProgramme update(Integer id, SessionProgramme sessionProgramme) {
        return sessionProgrammeService.update(id, sessionProgramme);
    }

    @Override
    public void delete(Integer id) {
        sessionProgrammeService.delete(id);
    }

    @Override
    public SessionProgramme save(SessionProgramme sessionProgramme) {
        return sessionProgrammeService.save(sessionProgramme);
    }
}
