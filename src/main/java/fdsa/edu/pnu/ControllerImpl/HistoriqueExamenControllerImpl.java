package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHistoriqueExamenController;
import fdsa.edu.pnu.Model.HistoriqueExam;
import fdsa.edu.pnu.ServiceImpl.HistoriqueExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class HistoriqueExamenControllerImpl implements IHistoriqueExamenController {
    @Autowired
    private HistoriqueExamServiceImpl historiqueExamServiceImpl;
    @Override
    public List<HistoriqueExam> findAll() {
        return historiqueExamServiceImpl.findAll();
    }

    @Override
    public Optional<HistoriqueExam> findById(Integer id) {
        return historiqueExamServiceImpl.findById(id);
    }

    @Override
    public HistoriqueExam update(Integer id, HistoriqueExam historiqueExam) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        historiqueExamServiceImpl.delete(id);
    }

    @Override
    public HistoriqueExam save(HistoriqueExam historiqueExam) {
        return historiqueExamServiceImpl.save(historiqueExam);
    }
}
