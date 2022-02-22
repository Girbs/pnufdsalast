/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Repository.RoleDAO;
import fdsa.edu.pnu.Service.IRoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleDAO roleDAO;


    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleDAO.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleDAO.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleDAO.deleteById(id);
    }
}
