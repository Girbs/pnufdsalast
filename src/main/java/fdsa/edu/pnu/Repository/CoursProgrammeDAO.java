package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.CoursProgramme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursProgrammeDAO extends JpaRepository<CoursProgramme, Integer> {


    @Query(value = "SELECT * FROM cours_programme", nativeQuery = true)
    List<CoursProgramme> findByAllCustomQuery();

    @Query(value = "{call FindCurriculumById(:IdCurriculum)}", nativeQuery = true)
    CoursProgramme findCurriculumById(@Param("IdCurriculum") Integer IdCurriculum);
}
