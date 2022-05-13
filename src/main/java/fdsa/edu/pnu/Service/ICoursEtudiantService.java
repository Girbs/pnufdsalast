package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.DTO.CoursEtudiantDto;
import fdsa.edu.pnu.Model.CoursEtudiant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICoursEtudiantService {
    List<CoursEtudiant> findAll();

    Optional<CoursEtudiant> findById(Integer id);

    String save(CoursEtudiant dto);
    String save(List<CoursEtudiant> dto);

    CoursEtudiant update(Integer id, CoursEtudiant coursEtudiant);

    void delete(Integer id);

    List<Integer> verifierChoixCours(Integer IdCoursProgramme, Integer IdEtudiant);

    CoursEtudiant calculmoyenneHelper(CoursEtudiant coursEtudiant);

    List<CoursEtudiant> findListCoursEtudiantByIdCours(Integer idCours);
    List<CoursEtudiantDto> ListeCoursEtudiant();
    List<CoursEtudiant> ListeCoursSessionEtudiantByProgramme(Integer idEtudiant, Integer idProgramme);

    Integer FindNombreDeCoursCompletedByEtudiantByProgramme( Integer idEtudiant , Integer idProgramme);

    Integer  findNombreDeCreditCompletedByEtudiantByProgramme (  Integer IdProgramme ,  Integer idEtudiant);

    Integer FindNombreDeCoursAReprendreByEtudiantByProgramme( Integer idEtudiant , Integer idProgramme);

    double pourcentageDeCreditCompletes ( Integer idEtudiant , Integer idProgramme);

    Integer findNombreDeCoursRestants (Integer idEtudiant , Integer idProgramme);

}
