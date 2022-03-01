/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.ResultatConcours;
import fdsa.edu.pnu.Model.HistoriqueExamenConcours;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IHistoriqueExamenConcoursService {

    List<HistoriqueExamenConcours> findAll();

    HistoriqueExamenConcours findById(Integer id);

    HistoriqueExamenConcours save(HistoriqueExamenConcours dto);

    List<ResultatConcours> findResultatExamenConcours(Integer idConcours);
    List<HistoriqueExamenConcours> findResultatExamenConcoursByPlanificationConcours( Integer IdPlanificationConcours);

    Page findResultatExamenConcoursPageable(int offset, int pageSize, String sortField, Integer idConcours, String sortDirection);

    void delete(Integer id);

}
