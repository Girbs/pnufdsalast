package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.CoursProgramme;

import java.util.List;
import java.util.Optional;

public interface ICoursProgrammeService {
    List<CoursProgramme> findAll();


    Optional<CoursProgramme> findById(Integer id);

    CoursProgramme save(CoursProgramme coursProgramme);

    CoursProgramme update(Integer id, CoursProgramme coursProgramme);

    void delete(Integer id);

    List<CoursProgramme> FindCoursProgrammeBySessionId(Integer IdSession);

   List <CoursProgramme>  FindListCoursProgrammeByEtudiant (Integer IdProgramme, Integer idEtudiant);
    Integer  findNombredeCreditsByProgramme (Integer IdProgramme);

    List <CoursProgramme>  ListCoursAndPrerequisByIdProgram (Integer idProgramme);

    Integer  findNombreDeCoursByProgramme (Integer IdProgramme);


}
