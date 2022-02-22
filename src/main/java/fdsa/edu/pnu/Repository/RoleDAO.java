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
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {

    @Query(value = "select r from Role r where r.roleName = Etudiant")
    Role findRoleEtudiant();

//	public Role loadRoleByORMID(String role) throws PersistentException;
//	public Role getRoleByORMID(String role) throws PersistentException;
//	public Role loadRoleByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role getRoleByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role loadRoleByORMID(PersistentSession session, String role) throws PersistentException;
//	public Role getRoleByORMID(PersistentSession session, String role) throws PersistentException;
//	public Role loadRoleByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role getRoleByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role[] listRoleByQuery(String condition, String orderBy) throws PersistentException;
//	public Role[] listRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public java.util.List queryRole(String condition, String orderBy) throws PersistentException;
//	public java.util.List queryRole(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public java.util.Iterator iterateRoleByQuery(String condition, String orderBy) throws PersistentException;
//	public java.util.Iterator iterateRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role[] listRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
//	public Role[] listRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public java.util.List queryRole(PersistentSession session, String condition, String orderBy) throws PersistentException;
//	public java.util.List queryRole(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public java.util.Iterator iterateRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
//	public java.util.Iterator iterateRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role loadRoleByQuery(String condition, String orderBy) throws PersistentException;
//	public Role loadRoleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role loadRoleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
//	public Role loadRoleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
//	public Role createRole();
//	public boolean save(pnu.Role role) throws PersistentException;
//	public boolean delete(pnu.Role role) throws PersistentException;
//	public boolean deleteAndDissociate(pnu.Role role) throws PersistentException;
//	public boolean deleteAndDissociate(pnu.Role role, org.orm.PersistentSession session) throws PersistentException;
//	public boolean refresh(pnu.Role role) throws PersistentException;
//	public boolean evict(pnu.Role role) throws PersistentException;
//	public Role loadRoleByCriteria(RoleCriteria roleCriteria);
//	public Role[] listRoleByCriteria(RoleCriteria roleCriteria);
}
