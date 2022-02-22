/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISessionController;
import fdsa.edu.pnu.Model.Session;
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
    public List<Session> findAll() {
        return sessionService.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return sessionService.findById(id);
    }

    @Override
    public Session update(Integer id, Session session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionService.delete(id);
    }

    @Override
    public Session save(Session session) {
        return sessionService.save(session);
    }
}

