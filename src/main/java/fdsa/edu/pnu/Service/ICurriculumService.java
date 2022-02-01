package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Curriculum;
import fdsa.edu.pnu.Model.Session;

import java.util.List;
import java.util.Optional;

public interface ICurriculumService {
    List<Curriculum> findAll();
    Optional<Curriculum> findById(Integer id);
    Curriculum save(Curriculum curriculum);
    Curriculum update(Integer id, Curriculum curriculum);
    void delete(Integer id);
}
