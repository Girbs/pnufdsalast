package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.IControllerEtudiant;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.ServiceImpl.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EtudiantControllerImpl implements IControllerEtudiant {
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
    public Concours update(Integer id, Concours dto) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        etudiantServiceImpl.delete(id);
    }

    @Override
    public Etudiant save(Etudiant dto) {
        return etudiantServiceImpl.save(dto);
    }
}
