package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IPermissionController;
import fdsa.edu.pnu.Model.Permission;
import fdsa.edu.pnu.ServiceImpl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class PermissionControllerImpl implements IPermissionController {

    @Autowired
    private PermissionServiceImpl permissionServiceImpl;


    @Override
    public List<Permission> findAll() {
        return permissionServiceImpl.findAll() ;
    }

    @Override
    public Optional<Permission> findById(Integer id) {
        return permissionServiceImpl.findById(id);
    }

    @Override
    public Permission save(Permission dto) {
        return permissionServiceImpl.save(dto);
    }

    @Override
    public void delete(Integer id) {
        permissionServiceImpl.delete(id);
    }
}
