package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IOrganisationExamenController;
import fdsa.edu.pnu.Model.OrganisationExamen;
import fdsa.edu.pnu.ServiceImpl.OrganisationExamenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrganisationExamenControllerImpl implements IOrganisationExamenController {
   @Autowired
    private OrganisationExamenServiceImpl organisationExamenServiceImpl;

    @Override
    public List<OrganisationExamen> findAll() {
        return organisationExamenServiceImpl.findAll();
    }

    @Override
    public Optional<OrganisationExamen> findById(Integer id) {
        return organisationExamenServiceImpl.findById(id);
    }

    @Override
    public OrganisationExamen save(OrganisationExamen organisationExamen) {
        return organisationExamenServiceImpl.save(organisationExamen);
    }

    @Override
    public void delete(Integer id) {
        organisationExamenServiceImpl.delete(id);
    }
}
