package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Personnel;

import java.util.List;
import java.util.Optional;

public interface IPersonnel {
    List<Personnel> findAll();

    Optional<Personnel> findById(Integer id);

    Personnel save(Personnel personnel);

    void delete(Integer id);
}
