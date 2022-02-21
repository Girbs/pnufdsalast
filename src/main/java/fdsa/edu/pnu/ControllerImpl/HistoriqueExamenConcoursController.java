
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHistoriqueExamenConcoursController;
import fdsa.edu.pnu.DTO.HistoriqueExamenConcoursDTO;
import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import fdsa.edu.pnu.ServiceImpl.HistoriqueExamenConcoursService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Richard
 */
@RestController
public class HistoriqueExamenConcoursController implements IHistoriqueExamenConcoursController {

    @Autowired
    public HistoriqueExamenConcoursService historiqueExamenConcoursService;

    @Override
    public List<HistoriqueExamenConcours> findAll() {
        return historiqueExamenConcoursService.findAll();
    }

    @Override
    public HistoriqueExamenConcours findById(Integer id) {
        return historiqueExamenConcoursService.findById(id);
    }

    @Override
    public HistoriqueExamenConcours save(HistoriqueExamenConcours dto) {
        return historiqueExamenConcoursService.save(dto);
    }

    @Override
    public void delete(Integer id) {
        historiqueExamenConcoursService.delete(id);
    }
}
