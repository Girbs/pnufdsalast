/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.PersonneDTO;

import java.util.List;

/**
 * @author gbijou
 */
public interface IPersonneService {

    public List<PersonneDTO> findAll();

    public PersonneDTO findById(Integer id);

    public PersonneDTO save(PersonneDTO dto);

    public void delete(Integer id);
}
