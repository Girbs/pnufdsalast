package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreDAO extends JpaRepository<Semestre, Integer> {
}
