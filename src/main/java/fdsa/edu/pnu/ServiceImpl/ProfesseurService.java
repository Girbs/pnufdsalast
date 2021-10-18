/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.ProfesseurDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Repository.ProfesseurDAO;
import fdsa.edu.pnu.Service.IProfesseurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Richard
 */

@Data
@Service
public class ProfesseurService implements IProfesseurService {

    @Autowired
    private ProfesseurDAO professeurDAO;

    @Override
    public List<ProfesseurDTO> findAll() {
        return professeurDAO.findAll().stream()
                .map(ProfesseurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProfesseurDTO findById(Integer id) {
        if (id == null) {
            return null;
        }
        return professeurDAO.findById(id).map(ProfesseurDTO::fromEntity).orElseThrow(()
                -> new EntityNotFoundException(
                "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ProfesseurDTO save(ProfesseurDTO dto) {

        return ProfesseurDTO.fromEntity(
                professeurDAO.save(
                        ProfesseurDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        professeurDAO.deleteById(id);
    }

    @Override
    public ProfesseurDTO update(@PathVariable("id") final Integer id, ProfesseurDTO dto) {

        ProfesseurDTO postulantDTO = findById(id);
        if(postulantDTO!=null) {
            return ProfesseurDTO.fromEntity(professeurDAO.save(ProfesseurDTO.toEntity(dto)));
        }
        return ProfesseurDTO.fromEntity(professeurDAO.save(ProfesseurDTO.toEntity(dto)));
    }

}




