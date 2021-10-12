/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.MatiereDTO;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IMatiereService {

    public List<MatiereDTO> findAll();

    public MatiereDTO findById(Integer id);

    public MatiereDTO save(MatiereDTO dto);

    public void delete(Integer id);
}
