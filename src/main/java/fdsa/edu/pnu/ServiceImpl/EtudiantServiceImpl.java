/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.Repository.EtudiantDAO;
import fdsa.edu.pnu.Service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
public class EtudiantServiceImpl implements IEtudiantService {
    @Autowired
    private EtudiantDAO etudiantDAO;


    @Override
    public List<Etudiant> findAll() {
        return etudiantDAO.findAll();
    }

    @Override
    public Optional<Etudiant> findById(Integer id) {
        return etudiantDAO.findById(id);
    }

    @Override
    public Etudiant save(Etudiant dto) {
        return etudiantDAO.save(dto);
    }

    @Override
    public void delete(Integer id) {
        etudiantDAO.deleteById(id);
    }

    @Override
    public Page<Etudiant> findAllWithPaginationAndSorting(int offset, int pageSize, String sortField, String searchfield, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Page<Etudiant> etudiants = etudiantDAO.findByAllDynameicSearch(searchfield, PageRequest.of(offset - 1, pageSize, sort));
        return etudiants;
    }
}
