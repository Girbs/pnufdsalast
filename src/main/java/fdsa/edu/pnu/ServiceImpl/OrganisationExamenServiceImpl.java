package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.OrganisationExamen;
import fdsa.edu.pnu.Repository.OrganisationExamenDAO;
import fdsa.edu.pnu.Service.IOrganisationExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationExamenServiceImpl implements IOrganisationExamenService {

    @Autowired
    private OrganisationExamenDAO organisationExamenDAO;

    @Override
    public List<OrganisationExamen> findAll() {
        return organisationExamenDAO.findAll();
    }

    @Override
    public Optional<OrganisationExamen> findById(Integer id) {
        return organisationExamenDAO.findById(id);
    }

    @Override
    public OrganisationExamen save(OrganisationExamen dto) {
        return organisationExamenDAO.save(dto);
    }

    @Override
    public void delete(Integer id) {
        organisationExamenDAO.deleteById(id);
    }
}
