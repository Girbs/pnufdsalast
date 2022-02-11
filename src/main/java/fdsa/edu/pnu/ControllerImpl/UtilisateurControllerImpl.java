/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.DTO.ChangerMotDePasseUtilisateurDto;
import fdsa.edu.pnu.DTO.UtilisateurDTO;
import fdsa.edu.pnu.Model.Utilisateur;
import fdsa.edu.pnu.ServiceImpl.UtilisateurService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import fdsa.edu.pnu.Controller.IUtilisateurController;
import javax.annotation.PostConstruct;
import fdsa.edu.pnu.Repository.UtilisateurDAO;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author Ing.Girbson BIJOU //
 */
@Transactional
@RestController
public class UtilisateurControllerImpl implements IUtilisateurController {


    @Autowired
    public UtilisateurService utilisateurService;

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public UtilisateurDTO save(UtilisateurDTO dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDTO changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        return utilisateurService.changerMotDePasse(dto);
    }

    @Override
    public Utilisateur motDePasseOublie(Utilisateur dto) {
        return utilisateurService.forgetPassword(dto);
    }

    @Override
    public Optional<Utilisateur> findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public Utilisateur update(Integer id, Utilisateur utilisateur) {
        return null;
    }


}
