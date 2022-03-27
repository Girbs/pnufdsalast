/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ISessionController;
import fdsa.edu.pnu.Model.Session;
import fdsa.edu.pnu.ServiceImpl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class SessionControllerImpl implements ISessionController {


    @Autowired

    private SessionServiceImpl sessionServiceImpl;

    @Override
    public List<Session> findAll() {
        return sessionServiceImpl.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return sessionServiceImpl.findById(id);
    }


    @Override
    public void delete(Integer id) {
        sessionServiceImpl.delete(id);
    }

    @Override
    public Session save(Session session) {
        return sessionServiceImpl.save(session);
    }
}

