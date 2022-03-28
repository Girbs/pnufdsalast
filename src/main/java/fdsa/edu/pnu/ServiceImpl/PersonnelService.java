/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Personnel;
import fdsa.edu.pnu.Repository.PersonnelDAO;
import fdsa.edu.pnu.Security.PasswordGenerator;
import fdsa.edu.pnu.Service.IPersonnel;
import fdsa.edu.pnu.mail.EmailController;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */

@Data
@Service


public class PersonnelService implements IPersonnel {

    @Autowired
    private PersonnelDAO personnelDAO;

    @Autowired
    private EmailController ec;

    @Autowired
    private PasswordGenerator password;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Personnel> findAll() {
        return personnelDAO.findAll();
    }

    @Override
    public Optional<Personnel> findById(Integer id) {
        return personnelDAO.findById(id);
    }


    @Override
    public Personnel save(Personnel personnel) {

        String pass = password.randomPassword();
        personnel.setUserPassword(passwordEncoder.encode(pass));

        ec.confirmerCreationPersonnel(personnel.getUserName(), personnel.getPrenom(), personnel.getNom(), personnel.getUserName(), pass);

        personnel.setUserPassword(passwordEncoder.encode(pass));
        return personnelDAO.save(personnel);
    }

    @Override
    public void delete(Integer id) {
        personnelDAO.deleteById(id);
    }
}
