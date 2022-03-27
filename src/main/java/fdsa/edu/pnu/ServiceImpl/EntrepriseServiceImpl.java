package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Entreprise;
import fdsa.edu.pnu.Repository.EntrepriseDAO;
import fdsa.edu.pnu.Service.IEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

    @Autowired

    private EntrepriseDAO entrepriseDAO;
    @Override
    public List<Entreprise> findAll() {
        return entrepriseDAO.findAll();
    }

    @Override
    public Optional<Entreprise> findById(Integer id) {
        return entrepriseDAO.findById(id);
    }

    @Override
    public Entreprise save(Entreprise entreprise) {
        return entrepriseDAO.save(entreprise);
    }

    @Override
    public void delete(Integer id) {
        entrepriseDAO.findById(id);
    }
}
