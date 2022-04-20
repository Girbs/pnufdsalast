package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.CoursProgramme;

import java.util.List;

public interface ICoursProgrammeService {
    List<CoursProgramme> findAll();


    CoursProgramme findById(Integer id);

    CoursProgramme save(CoursProgramme coursProgramme);

    CoursProgramme update(Integer id, CoursProgramme coursProgramme);

    void delete(Integer id);

    List<CoursProgramme> FindCoursProgrammeBySessionId(Integer IdSession);

   List <CoursProgramme>  FindListCoursProgrammeByEtudiant (Integer IdProgramme, Integer idEtudiant);
    Integer  findNombredeCreditsByProgramme (Integer IdProgramme);

    Integer  findNombreDeCreditCompletedByEtudiantByProgramme (  Integer IdProgramme ,  Integer idEtudiant);
    List <CoursProgramme>  ListCoursAndPrerequisByIdProgram (Integer idProgramme);




}
