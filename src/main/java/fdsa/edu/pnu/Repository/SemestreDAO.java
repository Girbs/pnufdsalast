package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreDAO extends JpaRepository<Session, Integer> {
}
