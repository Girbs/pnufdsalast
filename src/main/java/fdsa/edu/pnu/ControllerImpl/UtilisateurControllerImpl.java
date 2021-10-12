/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IUtilisateurController;
import fdsa.edu.pnu.DTO.UtilisateurDTO;
import fdsa.edu.pnu.Repository.UtilisateurDAO;
import fdsa.edu.pnu.ServiceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU //
 */
@RestController
public class UtilisateurControllerImpl implements IUtilisateurController {

    /**
     * @return the utlilisateurDAO
     */
    @Autowired
    public UtilisateurService utlisateurService;

    @Autowired
    private UtilisateurDAO utilisateurDAO;


//    @PostConstruct
//    public void initUser() {
//        utlisateurService.initUser();
//    }

    @Override
    public List<UtilisateurDTO> findAll() {
        return utlisateurService.findAll();
    }

    @Override
    public UtilisateurDTO save(UtilisateurDTO dto) {
        return utlisateurService.save(dto);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('Etudiant')")
    public String forUser() {
        return "This URL is only accessible Students";
    }
}
