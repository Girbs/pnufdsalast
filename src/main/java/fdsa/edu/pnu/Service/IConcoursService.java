package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Matiere;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IConcoursService {

    List<ConcoursDTO> findAll();

    ConcoursDTO findById(Integer id);

    Concours save(Concours dto);

    Concours update(Integer id, Concours concours);

    void delete(Integer id);

    List<Concours> findByAllCustomQuery();

    Page<Concours> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection);
}