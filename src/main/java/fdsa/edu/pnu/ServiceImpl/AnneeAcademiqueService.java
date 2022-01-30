/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import java.util.Optional;
import fdsa.edu.pnu.Model.AnneeAcademique;

import fdsa.edu.pnu.Service.IAnneeAcademiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fdsa.edu.pnu.Repository.AnneeAcademiqueDAO;

import java.util.List;

import lombok.Data;

@Data
@Service
public class AnneeAcademiqueService implements IAnneeAcademiqueService {

    @Autowired
    private AnneeAcademiqueDAO anneeAcademiqueDAO;

    @Override
    public List<AnneeAcademique> findAll() {
        return   anneeAcademiqueDAO.findAll();
    }

    @Override
    public Optional<AnneeAcademique> findById(Integer id) {
        return anneeAcademiqueDAO.findById(id);
    }

    @Override
    public AnneeAcademique save(AnneeAcademique anneeAcademique) {
        return anneeAcademiqueDAO.save(anneeAcademique);
    }

    @Override
    public AnneeAcademique update(Integer id, AnneeAcademique anneeAcademique) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        anneeAcademiqueDAO.deleteById(id);
    }
}
