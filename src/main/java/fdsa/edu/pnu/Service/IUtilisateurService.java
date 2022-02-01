/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ChangerMotDePasseUtilisateurDto;
import fdsa.edu.pnu.DTO.UtilisateurDTO;
import fdsa.edu.pnu.Model.Utilisateur;

import java.util.List;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IUtilisateurService {

    List<UtilisateurDTO> findAll();

    UtilisateurDTO findById(Integer id);

    UtilisateurDTO save(UtilisateurDTO dto);

    void delete(Integer id);

    UtilisateurDTO changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);
    Utilisateur forgetPassword(Utilisateur user);
}
