package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionDAO extends JpaRepository<Session, Integer> {
}
