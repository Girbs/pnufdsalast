/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;


import fdsa.edu.pnu.Controller.IAnneeAcademiqueController;
import fdsa.edu.pnu.Model.AnneeAcademique;
import fdsa.edu.pnu.ServiceImpl.AnneeAcademiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class AnneeAcademiqueController implements IAnneeAcademiqueController {

    @Autowired
    private AnneeAcademiqueService anneeAcademiqueService;

    @Override
    public List<AnneeAcademique> findAll() {
        return anneeAcademiqueService.findAll();
    }

    @Override
    public Optional<AnneeAcademique> findById(Integer id) {
        return anneeAcademiqueService.findById(id);
    }

    @Override
    public AnneeAcademique update(Integer id, AnneeAcademique anneeAcademique) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        anneeAcademiqueService.delete(id);
    }

    @Override
    public AnneeAcademique save(AnneeAcademique anneeAcademique) {
        return anneeAcademiqueService.save(anneeAcademique);
    }


//    // student
//    // old student
//    // admin
//    // teacher
//    // resctricted
//
//    hasRole("student", "oldStudent", "admin", "teacher")
//    public void getData() {
//
//    }
//
//    hasRole("admin", "teacher")
//    public void modifyData() {
//
//    }
//
//    hasRole("admin", "teacher")
//    public void deleteData() {
//
//    }
}
