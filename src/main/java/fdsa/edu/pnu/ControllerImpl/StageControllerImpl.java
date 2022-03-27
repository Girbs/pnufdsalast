package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IStageController;
import fdsa.edu.pnu.Model.Stage;
import fdsa.edu.pnu.ServiceImpl.StageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StageControllerImpl implements IStageController {

    @Autowired
    private StageServiceImpl stageServiceImpl;
    @Override
    public List<Stage> findAll() {
        return stageServiceImpl.findAll();
    }

    @Override
    public Optional<Stage> findById(Integer id) {
        return stageServiceImpl.findById(id);
    }

    @Override
    public Stage save(Stage dto) {
        return stageServiceImpl.save(dto);
    }

    @Override
    public void delete(Integer id) {
        stageServiceImpl.delete(id);
    }
}
