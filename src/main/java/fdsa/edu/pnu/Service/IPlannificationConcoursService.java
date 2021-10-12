/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.PlannificationConcoursDTO;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IPlannificationConcoursService {

    public List<PlannificationConcoursDTO> findAll();

    public PlannificationConcoursDTO findById(Integer id);

    public PlannificationConcoursDTO save(PlannificationConcoursDTO dto);

    public void delete(Integer id);
}
