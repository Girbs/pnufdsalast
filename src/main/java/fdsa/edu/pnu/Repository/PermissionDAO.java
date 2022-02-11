package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDAO extends JpaRepository<Permission, Integer> {
}
