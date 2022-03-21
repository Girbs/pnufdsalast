package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.CoursEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursEtudiantDAO extends JpaRepository<CoursEtudiant, Integer> {

   //Integer findByCoursProgrammeIdAndEtudiantId(Integer CoursProgrammeId, Integer EtudiantId);

//    @Query(value = "{call VerifyIfCoursAlreadyTaken(:IdProgrammeCours,: IdEtudiant)}", nativeQuery = true)
//    Integer verifierChoixCours(@Param("IdProgrammeCours") Integer IdCoursProgramme , @Param("IdEtudiant") Integer IdEtudiant);

}