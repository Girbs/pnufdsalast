/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.SessionProgramme;
import fdsa.edu.pnu.Repository.SessionProgrammeDAO;
import fdsa.edu.pnu.Service.ISessionProgramme;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class SessionProgrammeServiceImpl implements ISessionProgramme {
    @Autowired
    private SessionProgrammeDAO sessionProgrammeDAO;

    @Override
    public List<SessionProgramme> findAll() {
        return sessionProgrammeDAO.findByAllCustomQuery();
    }

    @Override
    public List<SessionProgramme> findSessionProgrammeByIdProgramme(Integer IdProgramme) {
        return sessionProgrammeDAO.findSessionProgrammeByIdProgramme(IdProgramme);
    }

    @Override
    public SessionProgramme findById(Integer id) {
        return sessionProgrammeDAO.findSessionProgrammeById(id);
    }

    @Override
    public SessionProgramme save(SessionProgramme session) {
        return sessionProgrammeDAO.save(session);
    }

    @Override
    public SessionProgramme update(Integer id, SessionProgramme session) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        sessionProgrammeDAO.deleteById(id);
    }
}

