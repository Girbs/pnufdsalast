/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Repository;


import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HistoriqueExamenConcoursDAO extends JpaRepository<HistoriqueExamenConcours, Integer> {

    @Query(value = "SELECT * FROM historique_examen_concours  WHERE  CONCAT( note_obtenue)  LIKE %:text%", nativeQuery = true)
    Page<HistoriqueExamenConcours> findByAllHistoriqueExamenConcoursDynamiqueSearch(@Param("text") String text, Pageable pageable);


    @Query(value = "{call ResultatExamenConcours(:idConcours)}", nativeQuery = true)
    List<Object> findResultatExamenConcours(@Param("idConcours") Integer idConcours);

//    @Query(value = "{call ResultatExamenConcours(:idConcours)}", nativeQuery = true)
//    List findResultatExamenConcoursPageable(@Param("idConcours") Integer idConcours, Pageable pageable);

    @Query(value = "SELECT  CONCAT( p.nom ,' ', p.prenom) as Etutiant, p.matricule as Matricule, AVG(h.note_obtenue) as Moyenne\n" +
            "FROM  [historique_examen_concours] h   INNER JOIN   [postulant] p\n" +
            "ON p.id = h.postulantid\n" +
            "INNER JOIN [dbo].[plannification_concours] ON [dbo].[plannification_concours].[id] = h.plannification_concoursid\n" +
            "WHERE [dbo].[plannification_concours].concours_id =?1\n" +
            "GROUP BY p.nom , p.prenom, p.matricule", nativeQuery = true)
    List findResultatExamenConcoursPageable(@Param("idConcours") Integer idConcours, Pageable pageable);

}
