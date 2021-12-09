package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Personnel;

import java.util.List;
import java.util.Optional;

public interface IPersonnel {
    public List<Personnel> findAll();

    public Optional<Personnel> findById(Integer id);

    public Personnel save(Personnel personnel);

    public void delete(Integer id);
}
