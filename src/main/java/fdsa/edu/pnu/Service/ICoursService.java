package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Cours;

import java.util.List;
import java.util.Optional;

public interface ICoursService {
    List<Cours> findAll();
    List<Cours> listCoursDisponible();
    Optional<Cours> findById(Integer id);
    Cours save(Cours cours);
    void delete(Integer id);
    Cours findCoursProgramByIdCours(Integer idCours);
}
