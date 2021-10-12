/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.UtilisateurDTO;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IUtilisateurService {

    public List<UtilisateurDTO> findAll();

    public UtilisateurDTO findById(Integer id);

    public UtilisateurDTO save(UtilisateurDTO dto);

    public void delete(Integer id);
}
