/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;


import fdsa.edu.pnu.DTO.UtilisateurDTO;
import fdsa.edu.pnu.Model.Utilisateur;
import fdsa.edu.pnu.Repository.UtilisateurDAO;
import fdsa.edu.pnu.Service.IUtilisateurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class UtilisateurService implements IUtilisateurService {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Optional<Utilisateur> getUtilisateur(final int id) {
        return utilisateurDAO.findById(id);
    }

    public Iterable<Utilisateur> getUtilisateur() {
        return utilisateurDAO.findAll();
    }

    public void deleteUtilisateur(final int id) {
        utilisateurDAO.deleteById(id);
    }


    @Override
    public List<UtilisateurDTO> findAll() {
        return utilisateurDAO.findAll().stream()
                .map(UtilisateurDTO::fromEntity)
                .collect(Collectors.toList());
    }


    public Utilisateur saveUtilisateur(Utilisateur Utilisateur) {
        Utilisateur savedUtilisateur = utilisateurDAO.save(Utilisateur);
        return savedUtilisateur;
    }

    @Override
    public UtilisateurDTO findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UtilisateurDTO save(UtilisateurDTO dto) {
        return UtilisateurDTO.fromEntity(utilisateurDAO.save(UtilisateurDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void initUser() {
        Utilisateur user = new Utilisateur();
        // user.setNom("bijou");
        user.setId(1);
        user.setUserName("aob");
        user.setUserPassword(getEncodedPassword("Algo2020"));
        utilisateurDAO.save(user);

    }
}
