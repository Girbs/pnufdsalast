/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.HistoriqueExamenConcours;

import java.util.List;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IHistoriqueExamenConcoursService {

    List<HistoriqueExamenConcours> findAll();

    HistoriqueExamenConcours findById(Integer id);

    HistoriqueExamenConcours save(HistoriqueExamenConcours dto);

    void delete(Integer id);

}
