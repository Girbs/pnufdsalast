/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ConcoursDTO;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IConcoursService {

    public List<ConcoursDTO> findAll();

    public ConcoursDTO findById(Integer id);

    public ConcoursDTO save(ConcoursDTO dto);

    public void delete(Integer id);
    public ConcoursDTO update(Integer id, ConcoursDTO dto);
}
