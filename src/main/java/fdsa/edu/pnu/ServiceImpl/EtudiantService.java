/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.EtudiantDTO;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.Repository.EtudiantDAO;
import fdsa.edu.pnu.Service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author EstherA
 */
public class EtudiantService implements IEtudiantService {
    @Autowired
    private EtudiantDAO etudiantDAO;

    public Optional<Etudiant> getEtudiant(final int id) {
        return etudiantDAO.findById(id);
    }

    public Iterable<Etudiant> getEtudiant() {
        return etudiantDAO.findAll();
    }

    public void deleteEtudiant(final int id) {
        etudiantDAO.deleteById(id);
    }

    public Etudiant saveEtudiant(Etudiant Etudiant) {
        Etudiant savedEtudiant = etudiantDAO.save(Etudiant);
        return savedEtudiant;
    }

    @Override
    public List<EtudiantDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EtudiantDTO findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EtudiantDTO save(EtudiantDTO dto) {
        return EtudiantDTO.fromEntity(
                etudiantDAO.save(
                        EtudiantDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
