package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> findAll();

    Optional<Role> findById(Integer id);

    Role save(Role role);

    void delete(Integer id);
}
