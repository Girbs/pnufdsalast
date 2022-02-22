/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import fdsa.edu.pnu.Repository.HistoriqueExamenConcoursDAO;
import fdsa.edu.pnu.Service.IHistoriqueExamenConcoursService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Setter
@Getter
@Service
public class HistoriqueExamenConcoursService implements IHistoriqueExamenConcoursService {

    @Autowired
    private HistoriqueExamenConcoursDAO historiqueExamenConcoursDAO;

    @Override
    public List<HistoriqueExamenConcours> findAll() {
        return historiqueExamenConcoursDAO.findAll();
    }

    @Override
    public HistoriqueExamenConcours findById(Integer id) {
        if (id == null) {
            return null;
        }
        return historiqueExamenConcoursDAO.findById(id).orElseThrow(()
                -> new EntityNotFoundException(
                "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public HistoriqueExamenConcours save(HistoriqueExamenConcours dto) {
        return historiqueExamenConcoursDAO.save(dto);
    }

    @Override
    public void delete(Integer id) {
        historiqueExamenConcoursDAO.deleteById(id);
    }

}
