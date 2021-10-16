/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Repository.RoleDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Jephthé Gédéon
 */
@Data
@Service
public class RoleService {
    @Autowired
    private RoleDAO roleDAO;

    public Optional<Role> getRole(final Integer id) {
        return roleDAO.findById(id);
    }

    public Iterable<Role> getRole() {
        return roleDAO.findAll();
    }

    public void deleteRole(final Integer id) {
        roleDAO.deleteById(id);
    }

    public Role saveRole(Role Role) {
        Role savedRole = roleDAO.save(Role);
        return savedRole;
    }

}
