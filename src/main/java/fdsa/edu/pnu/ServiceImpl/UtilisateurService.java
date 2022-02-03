/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;


import fdsa.edu.pnu.DTO.ChangerMotDePasseUtilisateurDto;
import fdsa.edu.pnu.DTO.UtilisateurDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Exception.InvalidOperationException;
import fdsa.edu.pnu.Model.Utilisateur;
import fdsa.edu.pnu.Repository.UtilisateurDAO;
import fdsa.edu.pnu.Security.PasswordGenerator;
import fdsa.edu.pnu.Service.IUtilisateurService;
import fdsa.edu.pnu.mail.EmailController;
import lombok.Data;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    private PasswordGenerator password;

    @Autowired
    private EmailController ec;

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
    public List<Utilisateur> findAll() {
        return utilisateurDAO.findAll();
       // .stream().map(UtilisateurDTO::fromEntity)
           //     .collect(Collectors.toList());
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

    @Override
    public UtilisateurDTO changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        validate(dto);
        Optional<Utilisateur> utilisateurOptional = utilisateurDAO.findByUsername(dto.getUserName());
        if (utilisateurOptional.isPresent()) {
            MessageUtil log = null;
            log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getUserName());
            throw new EntityNotFoundException("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getUserName(), ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        Utilisateur utilisateur = utilisateurOptional.get();
        utilisateur.setUserPassword(passwordEncoder.encode(dto.getMotDePasse()));

        return UtilisateurDTO.fromEntity(
                utilisateurDAO.save(utilisateur)
        );
    }
    @Override
    public Utilisateur forgetPassword(Utilisateur user) {
        Optional<Utilisateur> utilisateurOptional = utilisateurDAO.findByUsername(user.getUserName());

        Utilisateur utilisateur = null;
        MessageUtil log = null;
        if (utilisateurOptional.isPresent()) {
            utilisateur = utilisateurOptional.get();
            if (utilisateur.isStatus()) {
                String newPassword = password.randomPassword();
                utilisateur.setUserPassword(passwordEncoder.encode(newPassword));
                ec.motDePasseOublieConfirmationEmail(user.getUserName(), utilisateur.getPrenom(), utilisateur.getNom(), utilisateur.getUserName(), newPassword);
            } else {
                log.warn("utilisateur inactif");
                throw new InvalidOperationException("Utilisateur Inactif",
                        ErrorCodes.UTILISATEUR_INACTIF);
            }
        } else {
            log.warn("Cet utilisateur n'existe pas");
            throw new InvalidOperationException("Aucune information n'a ete retrouvée pour le nom d'utilisateur foruni",
                    ErrorCodes.UTILISATEUR_NOT_VALID);

        }
        return utilisateurDAO.save(utilisateur);
    }
    private void validate(ChangerMotDePasseUtilisateurDto dto) {
        MessageUtil log = null;
        if (dto == null) {
            log.warn("Impossible de modifier le mot de passe avec un objet NULL");
            throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getUserName() == null) {
            log.warn("Impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalidOperationException("ID utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
            throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }

}
