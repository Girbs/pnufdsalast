/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Session;
import fdsa.edu.pnu.Repository.SessionDAO;
import fdsa.edu.pnu.Service.ISessionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class SessionService implements ISessionService {
    @Autowired
    private SessionDAO sessionDAO;


    @Override
    public List<Session> findAll() {
        return sessionDAO.findAll();
    }

    @Override
    public Optional<Session> findById(Integer id) {
        return sessionDAO.findById(id);
    }

    @Override
    public Session save(Session session) {
        return sessionDAO.save(session);
    }

    @Override
    public Session update(Integer id, Session session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionDAO.deleteById(id);
    }
}

