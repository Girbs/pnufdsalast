package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import org.springframework.data.domain.Page;

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

    Page<Concours> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection);
}