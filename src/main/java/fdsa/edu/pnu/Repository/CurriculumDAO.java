package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumDAO extends JpaRepository<Curriculum, Integer> {
}
