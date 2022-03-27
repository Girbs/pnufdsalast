package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Entreprise;

import java.util.List;
import java.util.Optional;

public interface IEntrepriseService {
    List<Entreprise> findAll();
    Optional<Entreprise> findById(Integer id);
    Entreprise save(Entreprise entreprise);
    void delete(Integer id);

   // List<Entreprise> findEvaluationsByOrganisationExamenId(Integer idOrganisationExamen);
}
