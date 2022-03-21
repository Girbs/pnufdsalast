/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 */

/**
 * Licensee: 
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.Repository;


import fdsa.edu.pnu.Model.Postulant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulantDAO extends JpaRepository<Postulant, Integer> {

    //Calling Procedure Store
    @Query(value = "{call ApplicationParStatut(:appSatut)}", nativeQuery = true)
    List<Postulant> findAllByStatutApplicatin(@Param("appSatut") String appSatut);


    @Query(value = "select s from Postulant s where prenom like %?1%", nativeQuery = true)
    Page<Postulant> findByAllName(String prenom, Pageable pageable);

    //Calling Procedure Store+
//    @Query(value =  "{call PostulantRechercheDynamique (:CritereDeRecherche)}", nativeQuery = true)
//    Page<Postulant> findByAllDynameicSearch(@Param("CritereDeRecherche") String text , Pageable pageable);

    // This method is the same to the above one
    @Query(value = "SELECT * FROM Postulant  WHERE  CONCAT( nom , prenom, adresse, email , telephone, statut_application) LIKE %:text%", nativeQuery = true)
    Page<Postulant> findByAllDynameicSearch(@Param("text") String text, Pageable pageable);

//        @Query(value = "{call VerifyIfCoursAlreadyTaken(:IdProgrammeCours,: IdEtudiant)}", nativeQuery = true)
//    Integer verifierChoixCours(@Param("IdProgrammeCours") Integer IdCoursProgramme , @Param("IdEtudiant") Integer IdEtudiant);


    // @Query(value = "SELECT * FROM parent WHERE CONCAT(receiver, sender) like %:text%", nativeQuery = true)

//    @Procedure(procedureName = "ApplicationParStatut")
//    List<Postulant> findAllByStatutApplicatin(@Param("statut_application") String statut_application);
//

    // @Query(value = "SELECT * FROM Postulant u WHERE u.statut_application = ?1", nativeQuery = true)
    // List<Postulant> findAllByStatutApplication(String status);
//
//    @Query("SELECT * FROM Postulant u WHERE u.statut_application =  ?")
//    List<Postulant> findAllByStatutApplicatin( String statut_application);
}
