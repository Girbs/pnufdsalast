/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.Repository.ProgrammeDAO;

import java.util.List;
import java.util.Optional;

import fdsa.edu.pnu.Service.IProgrammeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jephthé Gédéon
 */
@Data
@Service
public class ProgrammeServiceImpl implements IProgrammeService {
     @Autowired
    private ProgrammeDAO programmeDAO;

    @Override
    public List<Programme> findAll() {
        return programmeDAO.findAll();
    }

    @Override
    public Optional<Programme> findById(Integer id) {
        return programmeDAO.findById(id);
    }

    @Override
    public Programme save(Programme programme) {
        return programmeDAO.save(programme);
    }

    @Override
    public Programme update(Integer id, Programme programme) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        programmeDAO.deleteById(id);
    }
}
