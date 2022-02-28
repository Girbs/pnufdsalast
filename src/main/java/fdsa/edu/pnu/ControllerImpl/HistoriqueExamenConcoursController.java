package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IHistoriqueExamenConcoursController;
import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import fdsa.edu.pnu.ServiceImpl.HistoriqueExamenConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
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
    public List findResultatExamenConcours(Integer id) {
        return historiqueExamenConcoursService.findResultatExamenConcours(id);
    }

    @Override
    public APIResponse<Page> findResultatExamenConcoursPageable(int offset, int pageSize, String field, Integer IdConcours, String sortDirection) {
        Page productsWithPagination = historiqueExamenConcoursService.findResultatExamenConcoursPageable(offset, pageSize, field, IdConcours, sortDirection);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
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
