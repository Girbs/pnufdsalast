package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.CoursEtudiant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ICoursEtudiantService {
    List<CoursEtudiant> findAll();

    Optional<CoursEtudiant> findById(Integer id);

    CoursEtudiant save(CoursEtudiant dto);

    CoursEtudiant update(Integer id, CoursEtudiant coursEtudiant);

    void delete(Integer id);

    CoursEtudiant verifierChoixCours(Integer IdCoursProgramme , Integer IdEtudiant);

    CoursEtudiant calculmoyenneHelper(CoursEtudiant coursEtudiant);
}
