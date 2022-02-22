/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.PersonneDTO;
import fdsa.edu.pnu.Model.Personne;
import fdsa.edu.pnu.Repository.PersonneDAO;
import fdsa.edu.pnu.Service.IPersonneService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */

@Data
@Service


public class PersonneService implements IPersonneService {


    @Autowired

    private PersonneDAO personneDAO;

    public Optional<Personne> getPersonne(final int id) {
        return personneDAO.findById(id);
    }

    public Iterable<Personne> getHoraire() {
        return personneDAO.findAll();
    }

    public void deletePersonne(final int id) {
        personneDAO.deleteById(id);
    }

    public Personne saveHoraire(Personne Personne) {
        Personne savedPersonne = personneDAO.save(Personne);
        return savedPersonne;
    }

    @Override
    public List<PersonneDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonneDTO findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonneDTO save(PersonneDTO dto) {
        return PersonneDTO.fromEntity(
                personneDAO.save(
                        PersonneDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
