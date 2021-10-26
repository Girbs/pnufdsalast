/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Model.Etudiant;

import java.util.List;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IPostulantService {
   
    public List<PostulantDTO> findAll();

    public PostulantDTO findById(Integer id);

    public PostulantDTO save(PostulantDTO dto);
    
    public Etudiant update(Integer id, PostulantDTO dto);

    public void delete(Integer id);
    
}
