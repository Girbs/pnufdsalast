package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.CoursEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CoursEtudiantDAO extends JpaRepository<CoursEtudiant, Integer> {
}