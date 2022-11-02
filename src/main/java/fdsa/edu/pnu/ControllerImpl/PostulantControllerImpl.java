/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import com.lowagie.text.DocumentException;
import fdsa.edu.pnu.Config.ExportService;
import fdsa.edu.pnu.Controller.IPostulantController;
import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Model.Postulant;
import fdsa.edu.pnu.ServiceImpl.PostulantService;
import fdsa.edu.pnu.mail.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */
@RestController
public class PostulantControllerImpl implements IPostulantController {

    @Autowired
    public PostulantService postulantService;

    @Autowired
    public EmailController seec;

    @Autowired
    ExportService exportService;


    @Override
    public List<PostulantDTO> findAll() {
        return postulantService.findAll();
    }

    @Override
    public Optional<Postulant> findById(Integer id) {
        return postulantService.findById(id);
    }

    @Override
    public Postulant save(Postulant postulant, MultipartFile file) {
        return postulantService.save(postulant, file);
    }

//    @Override
//    public Postulant save(Postulant dto) {
//        return postulantService.save(dto);
//    }



    @Override
    public void delete(Integer id) {
        postulantService.delete(id);
    }

//    @Override
//    public Etudiant update(Integer id, PostulantDTO dto) {
//        System.out.println("This method is getting called for update");
//        return postulantService.update(id, dto);
//    }

    @Override
    public List<Postulant> findByStatus(String status) {
        return postulantService.getApplicationParStatut(status);
    }

//    @Override
//    public APIResponse<Page<Postulant>> getAllPostulantsWithPaginationAndSort(int offset, int pageSize, String field) {
//        Page<Postulant> productsWithPagination = postulantService.findAllWithPaginationAndSorting(offset, pageSize, field);
//        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }

    // This is the Original SmsController. It works fine
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


//    @Override
//    public APIResponse<Page<Postulant>> findAllWithFilter(int offset, int pageSize, String field, String prenom) {
//        Page<Postulant> productsWithPagination = postulantService.findAllWithFilter(offset, pageSize, field, prenom);
//        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }

      @Override
      public void exportToPDF(HttpServletResponse response, Integer id)  throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        exportService.exportPDF(response, id);

    }

}
