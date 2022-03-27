package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseDAO extends JpaRepository<Entreprise, Integer> {
}
