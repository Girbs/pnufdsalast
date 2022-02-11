package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.PersonneDTO;
import fdsa.edu.pnu.Model.Permission;
import fdsa.edu.pnu.Repository.PermissionDAO;
import fdsa.edu.pnu.Service.IPermissionService;
import fdsa.edu.pnu.Service.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements IPermissionService{

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public List<Permission> findAll() {
        return permissionDAO.findAll();
    }

    @Override
    public Optional<Permission> findById(Integer id) {
        return permissionDAO.findById(id);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionDAO.save(permission);
    }

    @Override
    public void delete(Integer id) {
        permissionDAO.deleteById(id);
    }
}
