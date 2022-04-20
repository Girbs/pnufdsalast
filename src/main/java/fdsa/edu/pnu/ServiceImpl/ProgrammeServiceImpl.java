/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.ProgrammeDTO;
import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.Repository.ProgrammeDAO;
import fdsa.edu.pnu.Service.IProgrammeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class ProgrammeServiceImpl implements IProgrammeService {
    @Autowired
    private ProgrammeDAO programmeDAO;

    @Override
    public List<Programme> findAll() {
        return programmeDAO.findByAllCustomQuery();
    }

    @Override
    public Programme findById(Integer id) {
        return programmeDAO.findProgrammeById(id);
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

    @Override
    public List<ProgrammeDTO> FindListProgrammeByIdEtudiant(Integer idEtudiant) {


        List<Object> o = programmeDAO.FindListProgrammeByIdEtudiant(idEtudiant);
        List<ProgrammeDTO> programmeDTOList = new ArrayList<>();

        for (int i = 0; i < o.size(); i++) {

            Object[] oo = (Object[]) o.get(i);
            ProgrammeDTO rc = new ProgrammeDTO((Integer) oo[0], String.valueOf(oo[1]), String.valueOf(oo[2]));
            programmeDTOList.add(rc);

        }
        return programmeDTOList;

    }
}
