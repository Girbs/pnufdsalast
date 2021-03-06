package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Controller.ICoursProgrammeController;
import fdsa.edu.pnu.Model.CoursProgramme;
import fdsa.edu.pnu.ServiceImpl.CoursProgrammeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursProgrammeControllerImpl implements ICoursProgrammeController {


    @Autowired
    private CoursProgrammeServiceImpl coursProgrammeServiceImpl;

    @Override
    public List<CoursProgramme> findAll() {
        return coursProgrammeServiceImpl.findAll();
    }

    @Override
    public Optional<CoursProgramme> findById(Integer id) {
        return coursProgrammeServiceImpl.findById(id);
    }

    @Override
    public CoursProgramme update(Integer id, CoursProgramme coursProgramme) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        coursProgrammeServiceImpl.delete(id);
    }

    @Override
    public CoursProgramme save(CoursProgramme coursProgramme) {
        return coursProgrammeServiceImpl.save(coursProgramme);
    }

    @Override
    public List<CoursProgramme> FindCoursProgrammeBySessionId(Integer idSession) {
        return coursProgrammeServiceImpl.FindCoursProgrammeBySessionId(idSession);
    }



    @Override
    public List<CoursProgramme> FindListCoursProgrammeByEtudiant(Integer IdProgramme, Integer idEtudiant) {
        return coursProgrammeServiceImpl.FindListCoursProgrammeByEtudiant(IdProgramme, idEtudiant);
    }

    @Override
    public Integer findNombredeCreditsByProgramme(Integer IdProgramme) {
        int nombreDeCredit;
        if(coursProgrammeServiceImpl.findNombredeCreditsByProgramme(IdProgramme)==null){
            nombreDeCredit=0;
        }
       else nombreDeCredit = coursProgrammeServiceImpl.findNombredeCreditsByProgramme(IdProgramme);
      return  nombreDeCredit;
    }



    @Override
    public List<CoursProgramme> ListCoursAndPrerequisByIdProgram(Integer idProgramme) {
        return coursProgrammeServiceImpl.ListCoursAndPrerequisByIdProgram(idProgramme);
    }

    @Override
    public Integer findNombreDeCoursByProgramme(Integer IdProgramme) {
        return coursProgrammeServiceImpl.findNombreDeCoursByProgramme(IdProgramme);
    }
}
