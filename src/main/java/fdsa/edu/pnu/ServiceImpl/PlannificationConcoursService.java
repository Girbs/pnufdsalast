/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.PlannificationConcoursDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Model.Matiere;
import fdsa.edu.pnu.Model.PlannificationConcours;
import fdsa.edu.pnu.Repository.HistoriqueExamenConcoursDAO;
import fdsa.edu.pnu.Repository.MatiereDAO;
import fdsa.edu.pnu.Repository.PlannificationConcoursDAO;
import fdsa.edu.pnu.Service.IPlannificationConcoursService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
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
    public List<PlannificationConcoursDTO> findAll() {
        return plannificationConcoursDAO.findAll().stream()
                .map(PlannificationConcoursDTO::fromEntity)
                .collect(Collectors.toList());
    }
    
    @Override
    public PlannificationConcoursDTO findById(Integer id) {
        if (id == null) {
            return null;
        }
        return plannificationConcoursDAO.findById(id).map(PlannificationConcoursDTO::fromEntity).orElseThrow(()
                -> new EntityNotFoundException(
                        "Aucune plannification Concours avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }






    @Override
    public PlannificationConcours save(PlannificationConcours plannificationConcours) {
//        Matiere m = matiereDAO.findById(plannificationConcours.getMatiere().getId()).get();
//        plannificationConcours.setMatiere(m);
//        PlannificationConcours pc = plannificationConcoursDAO.save(plannificationConcours);
//        if( plannificationConcours.getHistoriqueExamenConcours()!=null) {
//            plannificationConcours.getHistoriqueExamenConcours().forEach(a -> {
//                a.setPlannificationConcours(pc);
//                historiqueExamenConcoursDAO.save(a);
//            });
//        }
        return plannificationConcoursDAO.save(plannificationConcours);
    }

//    @Override
//    public PlannificationConcours save(PlannificationConcours dto) {
//        return PlannificationConcoursDTO.fromEntity(
//                plannificationConcoursDAO.save(
//                        PlannificationConcoursDTO.toEntity(dto)
//                )
//        );
//    }
    
    @Override
    public void delete(Integer id) {
        plannificationConcoursDAO.deleteById(id);
    }
    
}
