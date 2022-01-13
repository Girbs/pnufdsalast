package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Cours;

import java.util.List;
import java.util.Optional;

public interface ICoursService {
    List<Cours> findAll();

    Optional<Cours> findById(Integer id);

    Cours save(Cours dto);

    void delete(Integer id);
}
