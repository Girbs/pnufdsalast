package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Cours;

import java.util.List;
import java.util.Optional;

public interface ICoursService {
    public List<Cours> findAll();

    public Optional<Cours> findById(Integer id);

    public Cours save(Cours dto);

    public void delete(Integer id);
}
