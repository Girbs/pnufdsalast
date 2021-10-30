/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.PlannificationConcoursDTO;
import fdsa.edu.pnu.Model.PlannificationConcours;

import java.util.List;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IPlannificationConcoursService {

    public List<PlannificationConcoursDTO> findAll();

    public PlannificationConcoursDTO findById(Integer id);

    public PlannificationConcours save(PlannificationConcours dto);

//    public PlannificationConcours update(Concours concours);

    public void delete(Integer id);
}
