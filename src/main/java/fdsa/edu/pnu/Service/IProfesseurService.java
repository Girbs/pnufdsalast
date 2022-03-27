package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ProfesseurDTO;
import fdsa.edu.pnu.Model.Professeur;

import java.util.List;

public interface IProfesseurService {

    List<Professeur> findAll();

    ProfesseurDTO findById(Integer id);

    Professeur save(Professeur dto);

    void delete(Integer id);
}
