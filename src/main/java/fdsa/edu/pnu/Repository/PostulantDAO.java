/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Repository;


import fdsa.edu.pnu.Model.Postulant;
import org.hibernate.LockMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulantDAO extends JpaRepository<Postulant,Integer> {


    @Query(value =  "{call ApplicationParStatut(:appSatut)}", nativeQuery = true)
    List<Postulant> findAllByStatutApplicatin(@Param("appSatut") String appSatut);


    @Query(value ="select s from Postulant s where prenom like %?1%",  nativeQuery = true)
    Page<Postulant> findByAllName(String prenom, Pageable pageable);


    @Query(value ="SELECT * FROM Postulant  WHERE  CONCAT( nom , prenom, adresse, email , telephone, statutApplication) LIKE %:text%" , nativeQuery = true)
    Page<Postulant> findByAllDynameicSearch(@Param("text") String text , Pageable pageable);

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
