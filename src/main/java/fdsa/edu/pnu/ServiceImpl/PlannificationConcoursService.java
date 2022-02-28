/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.PlannificationConcours;
import fdsa.edu.pnu.Repository.HistoriqueExamenConcoursDAO;
import fdsa.edu.pnu.Repository.MatiereDAO;
import fdsa.edu.pnu.Repository.PlannificationConcoursDAO;
import fdsa.edu.pnu.Service.IPlannificationConcoursService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Richard
 */
@Data
@Service

public class PlannificationConcoursService implements IPlannificationConcoursService {

    @Autowired
    private PlannificationConcoursDAO plannificationConcoursDAO;

    @Autowired
    private MatiereDAO matiereDAO;
    @Autowired
    private HistoriqueExamenConcoursDAO historiqueExamenConcoursDAO;

    @Override
    public List<PlannificationConcours> findAll() {
        return plannificationConcoursDAO.findAll();
    }

    @Override
    public PlannificationConcours findById(Integer id) {
        if (id == null) {
            return null;
        }
        return plannificationConcoursDAO.findPlannificationConcoursById(id);
    }


    @Override
    public PlannificationConcours save(PlannificationConcours plannificationConcours) {
        return plannificationConcoursDAO.save(plannificationConcours);
    }

    @Override
    public Page<PlannificationConcours> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Page<PlannificationConcours> plannificationConcours = plannificationConcoursDAO.findByAllPlannificationConcoursDynamiqueSearch(searchfield, PageRequest.of(offset - 1, pageSize, sort));
        return plannificationConcours;
    }

    @Override
    public List<PlannificationConcours> findPlannificationConcoursByIdConcours(Integer IdConcours) {
        return plannificationConcoursDAO.findPlannificationConcoursByIdConcours(IdConcours);
    }


    @Override
    public void delete(Integer id) {
        plannificationConcoursDAO.deleteById(id);
    }

}
