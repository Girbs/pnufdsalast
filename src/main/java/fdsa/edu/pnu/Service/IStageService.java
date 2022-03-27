package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Stage;

import java.util.List;
import java.util.Optional;

public interface IStageService {
    List<Stage> findAll();
    Optional<Stage> findById(Integer id);
    Stage save(Stage stage);
    void delete(Integer id);
}
