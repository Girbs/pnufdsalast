/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.Repository.ProgrammeDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jephthé Gédéon
 */
@Data
@Service
public class ProgrammeService {
     @Autowired
    private ProgrammeDAO programmeDAO;

    public Optional<Programme> getProgramme(final int id) {
        return programmeDAO.findById(id);
    }

    public Iterable<Programme> getProgramme() {
        return programmeDAO.findAll();
    }

    public void deleteProgramme(final int id) {
        programmeDAO.deleteById(id);
    }

    public Programme saveProgramme(Programme Programme) {
        Programme savedProgramme = programmeDAO.save(Programme);
        return savedProgramme;
    }
    
}
