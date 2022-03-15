package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.CoursEtudiant;

import java.util.List;
import java.util.Optional;

public interface ICoursEtudiantService {
    List<CoursEtudiant> findAll();

    Optional<CoursEtudiant> findById(Integer id);

    CoursEtudiant save(CoursEtudiant dto);

    CoursEtudiant update(Integer id, CoursEtudiant coursEtudiant);

    void delete(Integer id);


    CoursEtudiant calculmoyenneHelper(CoursEtudiant coursEtudiant);
}
