/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.EtudiantDTO;
import java.util.List;

/**
 *
 * @author gbijou
 */
public interface IEtudiantService {

    List<EtudiantDTO> findAll();
    EtudiantDTO findById(Integer id);
    EtudiantDTO save(EtudiantDTO dto);
    void delete(Integer id);
}
