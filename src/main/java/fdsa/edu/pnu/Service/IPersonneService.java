/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.PersonneDTO;
import java.util.List;

/**
 *
 * @author gbijou
 */
public interface IPersonneService {
    
    List<PersonneDTO> findAll();

    PersonneDTO findById(Integer id);

    PersonneDTO save(PersonneDTO dto);

    void delete(Integer id);
}
