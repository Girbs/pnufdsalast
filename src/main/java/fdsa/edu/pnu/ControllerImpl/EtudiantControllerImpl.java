package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IEtudiantController;
import fdsa.edu.pnu.DTO.APIResponse;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.ServiceImpl.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EtudiantControllerImpl implements IEtudiantController {
    @Autowired
    private EtudiantServiceImpl etudiantServiceImpl;

    @Override
    public List<Etudiant> findAll() {
        return etudiantServiceImpl.findAll();
    }

    @Override
    public Optional<Etudiant> findById(Integer id) {
        return etudiantServiceImpl.findById(id);
    }

    @Override
    public void delete(Integer id) {
        etudiantServiceImpl.delete(id);
    }

    @Override
    public Etudiant save(Etudiant dto) {
        return etudiantServiceImpl.save(dto);
    }

    @Override
    public APIResponse<Page<Etudiant>> getAllEtudiantsWithPaginationAndSort(int offset, int pageSize, String field, String searchFiled, String sortDirection) {
        Page<Etudiant> etudiantsWithPagination = etudiantServiceImpl.findAllWithPaginationAndSorting(offset, pageSize, field, searchFiled, sortDirection);
        return new APIResponse<Page<Etudiant>>(etudiantsWithPagination.getSize(), etudiantsWithPagination);
    }
}
