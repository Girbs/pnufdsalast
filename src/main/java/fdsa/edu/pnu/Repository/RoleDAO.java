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


import fdsa.edu.pnu.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {

 // @Query(value = "select r from Role r where r.roleName = Etudiant")
//    public Role findRoleEtudiant();
  //  Optional<Utilisateur> findRoleEtudiant(@Param("userName") String userName);

//    @Procedure
//    Role IdRoleEdtutiant();

    public  Role findByRoleName(String roleName);

}
