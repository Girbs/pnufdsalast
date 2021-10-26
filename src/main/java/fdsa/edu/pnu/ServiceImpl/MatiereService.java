/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.MatiereDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Repository.MatiereDAO;
import fdsa.edu.pnu.Service.IMatiereService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Richard
 */
@Data
@Service

public class MatiereService implements IMatiereService {

    @Autowired
    private MatiereDAO matiereDAO;

    @Override
    public List<MatiereDTO> findAll() {
        return matiereDAO.findAll().stream()
                .map(MatiereDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MatiereDTO findById(Integer id) {
        if (id == null) {
            return null;
        }
        return matiereDAO.findById(id).map(MatiereDTO::fromEntity).orElseThrow(()
                -> new EntityNotFoundException(
                        "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public MatiereDTO save(MatiereDTO dto) {

        return MatiereDTO.fromEntity(
                matiereDAO.save(
                        MatiereDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        matiereDAO.deleteById(id);
    }
}
