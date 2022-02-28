package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Curriculum;

import java.util.List;

public interface ICurriculumService {
    List<Curriculum> findAll();

    Curriculum findById(Integer id);

    Curriculum save(Curriculum curriculum);

    Curriculum update(Integer id, Curriculum curriculum);

    void delete(Integer id);
}
