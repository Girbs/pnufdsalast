package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IRoleController;
import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.ServiceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleControllerImpl implements IRoleController {

    @Autowired
    private RoleServiceImpl roleServiceimpl;
    @Override
    public List<Role> findAll() {
        return roleServiceimpl.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleServiceimpl.findById(id);
    }

    @Override
    public Role update(Integer id, Role role) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        roleServiceimpl.delete(id);
    }

    @Override
    public Role save(Role role) {
        return roleServiceimpl.save(role);
    }
}
