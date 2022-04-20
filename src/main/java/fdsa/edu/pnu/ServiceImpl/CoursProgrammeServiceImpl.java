package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.CoursProgramme;
import fdsa.edu.pnu.Repository.CoursProgrammeDAO;
import fdsa.edu.pnu.Service.ICoursProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursProgrammeServiceImpl implements ICoursProgrammeService {

    @Autowired
    private CoursProgrammeDAO coursProgrammeDAO;

    @Override
    public List<CoursProgramme> findAll() {
        return coursProgrammeDAO.findByAllCustomQuery();
    }

    @Override
    public CoursProgramme findById(Integer id) {

        return coursProgrammeDAO.findCurriculumById(id);
    }

    @Override
    public CoursProgramme save(CoursProgramme coursProgramme) {

        return coursProgrammeDAO.save(coursProgramme);
    }

    @Override
    public CoursProgramme update(Integer id, CoursProgramme coursProgramme) {

        return null;
    }

    @Override
    public void delete(Integer id) {
        coursProgrammeDAO.deleteById(id);
    }

    @Override
    public List<CoursProgramme> FindCoursProgrammeBySessionId(Integer IdSession) {
        return coursProgrammeDAO.FindCoursProgrammeBySessionId(IdSession);
    }

    @Override
    public List<CoursProgramme> FindListCoursProgrammeByEtudiant(Integer IdProgramme, Integer idEtudiant) {
        return coursProgrammeDAO.FindListCoursProgrammeByIdEtudiant(IdProgramme,idEtudiant );
    }

    @Override
    public Integer findNombredeCreditsByProgramme(Integer IdProgramme) {
        return coursProgrammeDAO.findNombredeCreditByProgramme(IdProgramme);
    }

    @Override
    public Integer findNombreDeCreditCompletedByEtudiantByProgramme(Integer IdProgramme, Integer idEtudiant) {
        return coursProgrammeDAO.findNombreDeCreditCompletedByEtudiantByProgramme(IdProgramme,idEtudiant);
    }

    @Override
    public List<CoursProgramme> ListCoursAndPrerequisByIdProgram(Integer idProgramme) {
        return coursProgrammeDAO.ListCoursAndPrerequisByIdProgram(idProgramme);
    }
}
