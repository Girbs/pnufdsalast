/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IPostulantController;
import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.Model.Postulant;
import fdsa.edu.pnu.ServiceImpl.PostulantService;
import fdsa.edu.pnu.mail.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Richard
 */
@RestController
public class PostulantControllerImpl implements IPostulantController {

    @Autowired
    public PostulantService postulantService;

    @Autowired
    public EmailController seec;

    /**
     * Selectionner par ID
     *
     * @return
     */
    @Override
    public List<PostulantDTO> findAll() {
        return postulantService.findAll();
    }

    @Override
    public PostulantDTO findById(Integer id) {
        return postulantService.findById(id);
    }

//    @Override
//    public Postulant save(Postulant dto) throws InterruptedException {
//        return postulantService.save(dto);
//    }

    @Override
    public void delete(Integer id) {
        postulantService.delete(id);
    }

    @Override
    public Etudiant update(Integer id, PostulantDTO dto) {
        System.out.println("This method is getting called for update");
        return postulantService.update(id, dto);
    }

    @Override
    public List<Postulant> findByStatus(String status) {
        return postulantService.getApplicationParStatut(status);
    }

    @Override
    public APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSort(int offset, int pageSize, String field) {
        Page<Postulant> productsWithPagination = postulantService.findAllWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    // This is the Original Controller. It works fine
//    @Override
//    public APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSortv1(int offset, int pageSize, String field, String searchFiled) {
//        Page<Postulant> productsWithPagination = postulantService.findAllWithPaginationAndSortingv1(offset, pageSize, field, searchFiled);
//        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }


    @Override
    public APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSortv1(int offset, int pageSize, String field, String searchFiled, String sortDirection) {
        Page<Postulant> productsWithPagination = postulantService.findAllWithPaginationAndSortingv1(offset, pageSize, field, searchFiled, sortDirection);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }


    @Override
    public APIResponse<Page<Postulant>> findAllWithFilter(int offset, int pageSize, String field, String prenom) {
        Page<Postulant> productsWithPagination = postulantService.findAllWithFilter(offset, pageSize, field, prenom);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

}
