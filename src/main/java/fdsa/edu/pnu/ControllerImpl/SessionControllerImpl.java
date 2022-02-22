/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISessionController;
import fdsa.edu.pnu.Model.SessionProgramme;
import fdsa.edu.pnu.ServiceImpl.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class SessionControllerImpl implements ISessionController {

    @Autowired
    private SessionService sessionService;

    @Override
    public List<SessionProgramme> findAll() {
        return sessionService.findAll();
    }

    @Override
    public Optional<SessionProgramme> findById(Integer id) {
        return sessionService.findById(id);
    }

    @Override
    public SessionProgramme update(Integer id, SessionProgramme session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionService.delete(id);
    }

    @Override
    public SessionProgramme save(SessionProgramme session) {
        return sessionService.save(session);
    }
}

