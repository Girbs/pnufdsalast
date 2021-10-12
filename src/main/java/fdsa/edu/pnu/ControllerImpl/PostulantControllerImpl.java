/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IPostulantController;
import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.ServiceImpl.PostulantService;
import fdsa.edu.pnu.mail.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Richard
 */
@RestController
public class PostulantControllerImpl implements IPostulantController {

    @Autowired
    public PostulantService postulantService;

    @Autowired
    public EmailController seec;


    /**
     * Selectionner par ID
     *
     * @return
     */
    @Override
    public List<PostulantDTO> findAll() {
        return postulantService.findAll();
    }

    @Override
    public PostulantDTO findById(Integer id) {
        return postulantService.findById(id);
    }


    @Override
    public PostulantDTO save(PostulantDTO dto) {
        seec.confirmerInscription(dto.getEmail(), dto.getNom(), dto.getPrenom());
        return postulantService.save(dto);
    }


    @Override
    public void delete(Integer id) {
        postulantService.delete(id);
    }

    @Override
    public PostulantDTO update(Integer id, PostulantDTO dto) {
        return postulantService.update(id, dto);
    }

}
