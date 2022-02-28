/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISessionController;
import fdsa.edu.pnu.Model.SessionProgramme;
import fdsa.edu.pnu.ServiceImpl.SessionProgrammeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SessionControllerImpl implements ISessionController {

    @Autowired
    private SessionProgrammeServiceImpl sessionProgrammeServiceImpl;

    @Override
    public List<SessionProgramme> findAll() {
        return sessionProgrammeServiceImpl.findAll();
    }

    @Override
    public SessionProgramme findById(Integer id) {
        return sessionProgrammeServiceImpl.findById(id);
    }

    @Override
    public SessionProgramme update(Integer id, SessionProgramme session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionProgrammeServiceImpl.delete(id);
    }

    @Override
    public SessionProgramme save(SessionProgramme session) {
        return sessionProgrammeServiceImpl.save(session);
    }
}

