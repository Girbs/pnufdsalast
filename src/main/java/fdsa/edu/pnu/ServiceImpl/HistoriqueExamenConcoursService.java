/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.ResultatConcours;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import fdsa.edu.pnu.Repository.HistoriqueExamenConcoursDAO;
import fdsa.edu.pnu.Service.IHistoriqueExamenConcoursService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ResultatConcours> findResultatExamenConcours(Integer idConcours) {
        List<Object> o = historiqueExamenConcoursDAO.findResultatExamenConcours(idConcours);
        List<ResultatConcours> lstResultatConcours = new ArrayList<>();

        for (int i = 0; i < o.size(); i++) {

            Object[] oo = (Object[]) o.get(i);
            ResultatConcours rc = new ResultatConcours(String.valueOf(oo[0]), String.valueOf(oo[1]), (double) oo[2]);
            lstResultatConcours.add(rc);
        }
        return lstResultatConcours;
    }

    @Override
    public Page findResultatExamenConcoursPageable(int offset, int pageSize, String sortField, Integer idConcours, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Page rlt = (Page) historiqueExamenConcoursDAO.findResultatExamenConcoursPageable(idConcours, PageRequest.of(offset - 1, pageSize, sort));
        return rlt;
    }

    @Override
    public void delete(Integer id) {
        historiqueExamenConcoursDAO.deleteById(id);
    }
}
