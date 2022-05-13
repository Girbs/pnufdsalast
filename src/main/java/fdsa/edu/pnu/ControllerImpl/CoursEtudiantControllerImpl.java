package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICoursEtudiantController;
import fdsa.edu.pnu.DTO.CoursEtudiantDto;
import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.ServiceImpl.CoursEtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursEtudiantControllerImpl implements ICoursEtudiantController {

    @Autowired
    private CoursEtudiantServiceImpl coursEtudiantServiceImpl;

    @Override
    public List<CoursEtudiant> findAll() {
        return coursEtudiantServiceImpl.findAll();
    }

    @Override
    public Optional<CoursEtudiant> findById(Integer id) {
        return coursEtudiantServiceImpl.findById(id);
    }

    @Override
    public void delete(Integer id) {
        coursEtudiantServiceImpl.delete(id);
    }

    @Override
    public ResponseEntity <String> save(CoursEtudiant dto) {
        String choixCours =  coursEtudiantServiceImpl.save(dto);
        return new ResponseEntity<String>(choixCours, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> save(List<CoursEtudiant> coursEtudiantList) {
        String choixCours =  coursEtudiantServiceImpl.save(coursEtudiantList);
        return new ResponseEntity<String>(choixCours, HttpStatus.OK);
    }

    @Override
    public List<CoursEtudiant> ListeCoursSessionEtudiantByProgramme(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantServiceImpl.ListeCoursSessionEtudiantByProgramme(idEtudiant,idProgramme );
    }


    @GetMapping(value = "/ListeCoursEtudiant/all")
    public List<CoursEtudiantDto> ListCoursEtudiant() {
        return coursEtudiantServiceImpl.ListeCoursEtudiant();
    }

    @Override
    public Integer FindNombreDeCoursCompletedByEtudiantByProgramme(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantServiceImpl.FindNombreDeCoursCompletedByEtudiantByProgramme(idEtudiant,idProgramme );
    }

    @Override
    public Integer FindNombreDeCoursAReprendreByEtudiantByProgramme(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantServiceImpl.FindNombreDeCoursCompletedByEtudiantByProgramme(idEtudiant,idProgramme );
    }

    @Override
    public double pourcentageDeCreditCompletes(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantServiceImpl.pourcentageDeCreditCompletes(idEtudiant, idProgramme);
    }

    @Override
    public Integer findNombreDeCoursRestants(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantServiceImpl.findNombreDeCoursRestants(idEtudiant,idProgramme);
    }

    @Override
    public Integer findNombreDeCreditCompletedByEtudiantByProgramme(Integer IdProgramme, Integer idEtudiant) {
        int nombreDeCredit;
        if(coursEtudiantServiceImpl.findNombreDeCreditCompletedByEtudiantByProgramme(IdProgramme, idEtudiant)==null){
            nombreDeCredit=0;
        }
        else nombreDeCredit = coursEtudiantServiceImpl.findNombreDeCreditCompletedByEtudiantByProgramme(IdProgramme, idEtudiant);
        return  nombreDeCredit;
    }
}
