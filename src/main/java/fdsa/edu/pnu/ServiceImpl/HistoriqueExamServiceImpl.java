package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.HistoriqueExam;
import fdsa.edu.pnu.Repository.HistoriqueExamDAO;
import fdsa.edu.pnu.Service.IHistoriqueExamenService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class HistoriqueExamServiceImpl implements IHistoriqueExamenService {

    @Autowired
    private HistoriqueExamDAO historiqueExamDAO;

    @Override
    public List<HistoriqueExam> findAll() {
        return   historiqueExamDAO.findAll();
    }


    @Override
    public Optional<HistoriqueExam> findById(Integer id) {
        return historiqueExamDAO.findById(id);
    }

    @Override
    public HistoriqueExam save(HistoriqueExam historiqueExam) {
        return historiqueExamDAO.save(historiqueExam);
    }

    @Override
    public void delete(Integer id) {
        historiqueExamDAO.deleteById(id);
    }
}
