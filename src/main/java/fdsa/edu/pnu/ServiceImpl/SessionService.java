/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Session;
import fdsa.edu.pnu.Repository.SessionDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class SessionService {
    @Autowired
    private SessionDAO sessionDAO;

    public Optional<Session> getSession(final int id) {
        return sessionDAO.findById(id);
    }

    public Iterable<Session> getSession() {
        return sessionDAO.findAll();
    }

    public void deleteSession(final int id) {
        sessionDAO.deleteById(id);
    }

    public Session saveSession(Session Session) {
        Session savedSession = sessionDAO.save(Session);
        return savedSession;
    }

}

