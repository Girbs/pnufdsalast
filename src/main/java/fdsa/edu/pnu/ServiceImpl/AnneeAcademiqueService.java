/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.AnneeAcademique;
import fdsa.edu.pnu.Repository.AnneeAcademiqueDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AnneeAcademiqueService {

    @Autowired
    private AnneeAcademiqueDAO anneeAcademiqueDAO;

    public Iterable<AnneeAcademique> getAnneeAcademique() {
        return anneeAcademiqueDAO.findAll();
    }

}
