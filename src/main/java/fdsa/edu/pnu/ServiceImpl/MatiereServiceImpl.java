/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;


import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.Repository.MatiereDAO;
import fdsa.edu.pnu.Service.IMatiereService;
import java.util.List;
import java.util.Optional;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service

public class MatiereServiceImpl implements IMatiereService {

    @Autowired
    private MatiereDAO matiereDAO;

    @Override
    public List<Matiere> findAll() {
        return matiereDAO.findAll();
    }

    @Override
    public Optional<Matiere> findById(Integer id) {
        return matiereDAO.findById(id);
    }

    @Override
    public Matiere save(Matiere matiere) {
        return matiereDAO.save(matiere);
    }

    @Override
    public void delete(Integer id) {
        matiereDAO.deleteById(id);
    }
}
