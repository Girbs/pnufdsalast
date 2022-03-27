package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Stage;
import fdsa.edu.pnu.Repository.StageDAO;
import fdsa.edu.pnu.Service.IStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StageServiceImpl implements IStageService {

    @Autowired
    private StageDAO stageDAO;

    @Override
    public List<Stage> findAll() {
        return stageDAO.findAll();
    }

    @Override
    public Optional<Stage> findById(Integer id) {
        return stageDAO.findById(id);
    }

    @Override
    public Stage save(Stage stage) {
        return stageDAO.save(stage);
    }

    @Override
    public void delete(Integer id) {
        stageDAO.deleteById(id);
    }
}
