/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.ProfesseurDTO;
import fdsa.edu.pnu.Model.Professeur;
import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Repository.ProfesseurDAO;
import fdsa.edu.pnu.Repository.RoleDAO;
import fdsa.edu.pnu.Security.PasswordGenerator;
import fdsa.edu.pnu.Service.IProfesseurService;
import fdsa.edu.pnu.mail.EmailController;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Richard
 */

@Data
@Service


public class ProfesseurService implements IProfesseurService {

    @Autowired
    private ProfesseurDAO professeurDAO;

    @Autowired
    private EmailController ec;
    @Autowired
    private PasswordGenerator password;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<ProfesseurDTO> findAll() {
        return null;
    }

    @Override
    public ProfesseurDTO findById(Integer id) {
        return null;
    }

//    @Override
//    public ProfesseurDTO save(ProfesseurDTO dto) {
//
//       dto.setPassword("Pass");
//       return ProfesseurDTO.fromEntity(
//               professeurDAO.save(
//                        ProfesseurDTO.toEntity(dto)
//                )
//        );
//    }

    @Override
    public Professeur save(Professeur professeur) {

        //String pass = "Pass";
        String pass = password.randomPassword();
        System.out.println(pass);
        System.out.println(pass);
        professeur.setUserPassword(passwordEncoder.encode(pass));
        Set<Role> role = new HashSet<>();
        // role.add(new Role());
        role.add(roleDAO.findById(2).get());
        //  role.add(roleDAO.findById(2).get());
        professeur.setRoles(role);
        ec.confirmerCreationProfesseur(professeur.getUserName(), professeur.getPrenom(), professeur.getNom(), professeur.getUserName(), professeur.getUserPassword());
        return professeurDAO.save(professeur);
    }

    @Override
    public void delete(Integer id) {

    }
}
