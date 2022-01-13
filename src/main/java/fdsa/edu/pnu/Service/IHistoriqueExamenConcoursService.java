/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.HistoriqueExamenConcoursDTO;
import java.util.List;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IHistoriqueExamenConcoursService {

    List<HistoriqueExamenConcoursDTO> findAll();

    HistoriqueExamenConcoursDTO findById(Integer id);

    HistoriqueExamenConcoursDTO save(HistoriqueExamenConcoursDTO dto);

    void delete(Integer id);

}
