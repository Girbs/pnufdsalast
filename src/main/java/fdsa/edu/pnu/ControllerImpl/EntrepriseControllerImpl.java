package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IEntrepriseController;
import fdsa.edu.pnu.Model.Entreprise;
import fdsa.edu.pnu.ServiceImpl.EntrepriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class EntrepriseControllerImpl implements IEntrepriseController {
    @Autowired
    private EntrepriseServiceImpl entrepriseService;

    @Override
    public List<Entreprise> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public Optional<Entreprise> findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public Entreprise save(Entreprise dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
