/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.Model.Postulant;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author Ing.Girbson BIJOU
 */
public interface IPostulantService {

    List<PostulantDTO> findAll();

    Optional<Postulant> findById(Integer id);

    Postulant save(Postulant dto);

    
     //Etudiant update(Integer id, PostulantDTO dto);

    void delete(Integer id);

    List<Postulant> getApplicationParStatut(String statut_application);

    Page<Postulant> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection);

}
