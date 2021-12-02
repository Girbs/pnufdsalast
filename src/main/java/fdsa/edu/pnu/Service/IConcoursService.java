package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Matiere;

import java.util.List;

/**
 *
 * @author Ing.Girbson BIJOU
 */
public interface IConcoursService {

    public List<ConcoursDTO> findAll();

    public ConcoursDTO findById(Integer id);

    public Concours save(Concours dto);
    public Concours saveRelatedRecords(Concours concours, Matiere matiere);

    public void delete(Integer id);
}