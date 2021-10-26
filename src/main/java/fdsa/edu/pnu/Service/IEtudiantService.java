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

    public List<EtudiantDTO> findAll();
    public EtudiantDTO findById(Integer id);
    public EtudiantDTO save(EtudiantDTO dto);
    public void delete(Integer id);
}
