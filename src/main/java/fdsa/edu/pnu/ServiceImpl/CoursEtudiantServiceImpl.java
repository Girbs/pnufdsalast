package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Repository.CoursEtudiantDAO;
import fdsa.edu.pnu.Service.ICoursEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CoursEtudiantServiceImpl implements ICoursEtudiantService {

    @Autowired
    private CoursEtudiantDAO coursEtudiantDAO;

    @Autowired
    private CoursServiceImpl coursService;

    @Override
    public List<CoursEtudiant> findAll() {
        return coursEtudiantDAO.findAll();
    }

    @Override
    public Optional<CoursEtudiant> findById(Integer id) {
        return coursEtudiantDAO.findById(id);
    }

    @Override
    public CoursEtudiant save(CoursEtudiant dto) {
         Cours c = coursService.findCoursProgramByIdCours(dto.getCours().getId());
         List<Integer> ce = verifierChoixCours(c.getCoursProgramme().getId(), dto.getEtudiant().getId());
            if(ce.isEmpty()){
                dto.setType("Session Ordinaire");
            }else{
                dto.setType("Rappel");
            }
        return coursEtudiantDAO.save(dto);
    }

    @Override
    public CoursEtudiant update(Integer id, CoursEtudiant coursEtudiant) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
    @Override
    public List<Integer> verifierChoixCours(Integer IdCoursProgramme, Integer IdEtudiant) {
        return coursEtudiantDAO.verifierChoixCours(IdCoursProgramme, IdEtudiant);

    }

    @Override
    public CoursEtudiant calculmoyenneHelper(CoursEtudiant coursEtudiant) {
        if (coursEtudiant.getNote() >= 95) {
            coursEtudiant.setMention("Exeptionnel");
            coursEtudiant.setCote("A+");
            coursEtudiant.setNumbrePoint(4);
        } else if (coursEtudiant.getNote() < 95 && coursEtudiant.getNote() >= 85) {
            coursEtudiant.setMention("Excellent");
            coursEtudiant.setCote("A");
            coursEtudiant.setNumbrePoint(4);
        } else if (coursEtudiant.getNote() < 85 && coursEtudiant.getNote() >= 80) {
            coursEtudiant.setMention("Très Bien");
            coursEtudiant.setCote("B+");
            coursEtudiant.setNumbrePoint(3.5);
        } else if (coursEtudiant.getNote() < 80 && coursEtudiant.getNote() >= 70) {
            coursEtudiant.setMention("Très Bien");
            coursEtudiant.setCote("B");
            coursEtudiant.setNumbrePoint(3);
        } else if (coursEtudiant.getNote() < 70 && coursEtudiant.getNote() >= 65) {
            coursEtudiant.setMention("Bien");
            coursEtudiant.setCote("C+");
            coursEtudiant.setNumbrePoint(2.5);
            } else if (coursEtudiant.getNote() < 65 && coursEtudiant.getNote() >= 60) {
                coursEtudiant.setMention("Bien");
                coursEtudiant.setCote("C");
                coursEtudiant.setNumbrePoint(2);
            } else if (coursEtudiant.getNote() < 60 && coursEtudiant.getNote() >= 55) {
                coursEtudiant.setMention("Passable");
                coursEtudiant.setCote("D+");
                coursEtudiant.setNumbrePoint(1.5);
            } else if (coursEtudiant.getNote() < 55 && coursEtudiant.getNote() >= 50) {
                coursEtudiant.setMention("Passable");
                coursEtudiant.setCote("D");
                coursEtudiant.setNumbrePoint(1);
            } else {
                coursEtudiant.setMention("Echèc");
                coursEtudiant.setCote("F");
                coursEtudiant.setNumbrePoint(0);
            }
      return coursEtudiantDAO.save(coursEtudiant);
    }
}
