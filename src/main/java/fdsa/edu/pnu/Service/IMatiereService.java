/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.MatiereDTO;
import java.util.List;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IMatiereService {

    List<MatiereDTO> findAll();

    MatiereDTO findById(Integer id);

    MatiereDTO save(MatiereDTO dto);

    void delete(Integer id);
}
