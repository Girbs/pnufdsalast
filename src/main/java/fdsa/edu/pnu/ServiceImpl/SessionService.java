/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.SessionProgramme;
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
    public List<SessionProgramme> findAll() {
        return sessionDAO.findAll();
    }

    @Override
    public Optional<SessionProgramme> findById(Integer id) {
        return sessionDAO.findById(id);
    }

    @Override
    public SessionProgramme save(SessionProgramme session) {
        return sessionDAO.save(session);
    }

    @Override
    public SessionProgramme update(Integer id, SessionProgramme session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionDAO.deleteById(id);
    }
}

