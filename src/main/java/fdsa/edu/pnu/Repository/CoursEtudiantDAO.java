package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.CoursEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursEtudiantDAO extends JpaRepository<CoursEtudiant, Integer> {

    //Integer findByCoursProgrammeIdAndEtudiantId(Integer CoursProgrammeId, Integer EtudiantId);


    @Query(value = "{call VerifyIfCoursAlreadyTaken(:IdProgrammeCours,:idEtudiant)}", nativeQuery = true)
    List<Integer> verifierChoixCours(@Param("IdProgrammeCours") Integer IdCoursProgramme, @Param("idEtudiant") Integer idEtudiant);


    @Query(value = "{call findListCoursEtudiantByIdCours(:idCours)}", nativeQuery = true)
    List<CoursEtudiant> findListCoursEtudiantByIdCours(@Param("idCours") Integer idCours);

//    @Query(value ="{call VerifyIfCoursAlreadyTaken(:IdProgrammeCours)}", nativeQuery = true)
//    List<CoursEtudiant> verifierChoixCours(@Param("IdProgrammeCours") Integer IdCoursProgramme );



    @Query(value = "{call FindCoursEtudiantByIdEtudiantByProgramme(:idEtudiant,:idProgramme)}", nativeQuery = true)
    List<CoursEtudiant> FindCoursEtudiantByIdEtudiantByProgramme(@Param("idEtudiant") Integer idEtudiant , @Param("idProgramme")Integer idProgramme);

    @Query(value = "{call FindNombreDeCoursCompletedByEtudiantByProgramme(:idEtudiant,:idProgramme)}", nativeQuery = true)
    Integer FindNombreDeCoursCompletedByEtudiantByProgramme(@Param("idEtudiant") Integer idEtudiant , @Param("idProgramme")Integer idProgramme);


    @Query(value = "{call FindNombreDeCoursAReprendreByEtudiantByProgramme(:idEtudiant,:idProgramme)}", nativeQuery = true)
    Integer FindNombreDeCoursAReprendreByEtudiantByProgramme(@Param("idEtudiant") Integer idEtudiant , @Param("idProgramme")Integer idProgramme);

    @Query(value = "{call findNombreDeCreditCompletedByEtudiantByProgramme(:IdProgramme, :idEtudiant)}", nativeQuery = true)
    Integer  findNombreDeCreditCompletedByEtudiantByProgramme (@Param("IdProgramme")   Integer IdProgramme , @Param("idEtudiant")  Integer idEtudiant);


}