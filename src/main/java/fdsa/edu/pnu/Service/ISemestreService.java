package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Semestre;

import java.util.List;
import java.util.Optional;

public interface ISemestreService {

    List<Semestre> findAll();

    Optional<Semestre> findById(Integer id);

    Semestre save(Semestre semestre);

    Semestre update(Integer id, Semestre semestre);

    void delete(Integer id);
}
