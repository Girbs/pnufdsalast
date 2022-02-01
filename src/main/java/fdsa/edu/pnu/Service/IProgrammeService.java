package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Programme;
import fdsa.edu.pnu.Model.Semestre;

import java.util.List;
import java.util.Optional;

public interface IProgrammeService {
    List<Programme> findAll();
    Optional<Programme> findById(Integer id);
    Programme save(Programme programme);
    Programme update(Integer id, Programme programme);
    void delete(Integer id);
}
