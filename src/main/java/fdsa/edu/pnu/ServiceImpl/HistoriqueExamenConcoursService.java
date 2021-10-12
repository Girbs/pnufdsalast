/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.HistoriqueExamenConcoursDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Repository.HistoriqueExamenConcoursDAO;
import fdsa.edu.pnu.Service.IHistoriqueExamenConcoursService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Richard
 */
@Data
@Service
public class HistoriqueExamenConcoursService implements IHistoriqueExamenConcoursService {

    @Autowired
    private HistoriqueExamenConcoursDAO historiqueExamenConcoursDAO;

    @Override
    public List<HistoriqueExamenConcoursDTO> findAll() {
        return historiqueExamenConcoursDAO.findAll().stream()
                .map(HistoriqueExamenConcoursDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public HistoriqueExamenConcoursDTO findById(Integer id) {
        if (id == null) {
            return null;
        }
        return historiqueExamenConcoursDAO.findById(id).map(HistoriqueExamenConcoursDTO::fromEntity).orElseThrow(()
                -> new EntityNotFoundException(
                "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public HistoriqueExamenConcoursDTO save(HistoriqueExamenConcoursDTO dto) {
        return HistoriqueExamenConcoursDTO.fromEntity(
                historiqueExamenConcoursDAO.save(
                        HistoriqueExamenConcoursDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        historiqueExamenConcoursDAO.deleteById(id);
    }

}
