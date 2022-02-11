package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Permission;
import fdsa.edu.pnu.Model.Personnel;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    List<Permission> findAll();

    Optional<Permission> findById(Integer id);

    Permission save(Permission permission);

    void delete(Integer id);
}
