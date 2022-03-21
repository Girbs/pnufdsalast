package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.OrganisationExamen;

import java.util.List;
import java.util.Optional;

public interface IOrganisationExamenService {

    List<OrganisationExamen> findAll();

    Optional<OrganisationExamen> findById(Integer id);

    OrganisationExamen save(OrganisationExamen dto);

    void delete(Integer id);
}
