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

import fdsa.edu.pnu.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer> {

    // public Object findByUsername(String userName);
    @Query(value = "select u from Utilisateur u where u.userName = :userName")
    Optional<Utilisateur> findByUsername(@Param("userName") String userName);

}
