package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CurriculumDAO extends JpaRepository<Curriculum, Integer> {



    @Query(value = "SELECT * FROM Curriculum", nativeQuery = true)
    List<Curriculum> findByAllCustomQuery();

    @Query(value = "{call FindCurriculumById(:IdCurriculum)}", nativeQuery = true)
    Curriculum findCurriculumById(@Param("IdCurriculum") Integer IdCurriculum);
}
