package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ProfesseurDTO;
import fdsa.edu.pnu.Model.Professeur;

import java.util.List;

public interface IProfesseurService {

    public List<ProfesseurDTO> findAll();

    public ProfesseurDTO findById(Integer id);

    public Professeur save(Professeur dto);

    public void delete(Integer id);
}
