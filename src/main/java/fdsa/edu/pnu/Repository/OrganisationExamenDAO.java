package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.OrganisationExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrganisationExamenDAO extends JpaRepository<OrganisationExamen, Integer> {


}
