/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IProfesseurController;
import fdsa.edu.pnu.DTO.ProfesseurDTO;
import fdsa.edu.pnu.Model.Professeur;
import fdsa.edu.pnu.ServiceImpl.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Richard
 */
@RestController
public class ProfesseurController implements IProfesseurController {

    @Autowired
    public ProfesseurService professeurService;


    @Override
    public List<ProfesseurDTO> findAll() {
        return professeurService.findAll();
    }

    @Override
    public ProfesseurDTO findById(Integer id) {
        return professeurService.findById(id);
    }

    @Override
    public Professeur save(Professeur dto) {
        return professeurService.save(dto);
    }

//    @Override
//    public ProfesseurDTO save(ProfesseurDTO dto) {
//        return professeurService.save(dto);
//    }

    @Override
    public void delete(Integer id) {
        professeurService.delete(id);

    }
}
