package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.CoursEtudiantDto;
import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Repository.CoursEtudiantDAO;
import fdsa.edu.pnu.Service.ICoursEtudiantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursEtudiantServiceImpl implements ICoursEtudiantService {

    @Autowired
    private CoursEtudiantDAO coursEtudiantDAO;

    @Autowired
    private CoursProgrammeServiceImpl coursProgrammeService;

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
    public String save(CoursEtudiant dto) {
        Cours c = coursService.findCoursProgramByIdCours(dto.getCours().getId());
        List<Integer> ce = verifierChoixCours(c.getCoursProgramme().getId(), dto.getEtudiant().getId());
        if (ce.isEmpty()) {
            dto.setType("Session Ordinaire");
        } else {
            dto.setType("Rappel");
        }
        coursEtudiantDAO.save(dto);

        return "Succes";
    }

    @Override
    public String save(List<CoursEtudiant> dto) {
       CoursEtudiant ce = new CoursEtudiant();
       for(CoursEtudiant c : dto){
           coursEtudiantDAO.save(c);
       }
       return "La liste de cours a ete enregistré avec succes";
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

    @Override
    public List<CoursEtudiant> findListCoursEtudiantByIdCours(Integer idCours) {
        return coursEtudiantDAO.findListCoursEtudiantByIdCours(idCours);
    }

    @Override
    public List<CoursEtudiantDto> ListeCoursEtudiant() {
        List<CoursEtudiant> ce = coursEtudiantDAO.findAll();

        List<CoursEtudiantDto> cedto = new ArrayList<>();

        for(CoursEtudiant c: ce){
            CoursEtudiantDto cdt = new CoursEtudiantDto();
            BeanUtils.copyProperties(c, cdt);
            cedto.add(cdt);
        }

        return cedto;
    }

    @Override
    public List<CoursEtudiant> ListeCoursSessionEtudiantByProgramme(Integer idEtudiant, Integer idProgramme) {

        return coursEtudiantDAO.ListeCoursSessionEtudiantByProgramme(idEtudiant, idProgramme );
    }

    @Override
    public Integer FindNombreDeCoursCompletedByEtudiantByProgramme(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantDAO.FindNombreDeCoursCompletedByEtudiantByProgramme(idEtudiant, idProgramme );
    }

    @Override
    public Integer FindNombreDeCoursAReprendreByEtudiantByProgramme(Integer idEtudiant, Integer idProgramme) {
        return coursEtudiantDAO.FindNombreDeCoursAReprendreByEtudiantByProgramme(idEtudiant, idProgramme );
    }

    @Override
    public Integer findNombreDeCreditCompletedByEtudiantByProgramme(Integer IdProgramme, Integer idEtudiant) {
        return coursEtudiantDAO.findNombreDeCreditCompletedByEtudiantByProgramme(IdProgramme,idEtudiant);
    }


    @Override
    public double pourcentageDeCreditCompletes(Integer idEtudiant, Integer idProgramme) {
        double pourcentage;
        Integer nombreDeCreditCompletes = findNombreDeCreditCompletedByEtudiantByProgramme(idEtudiant, idProgramme);
        Integer nombredeCreditDuProgramme= coursProgrammeService.findNombredeCreditsByProgramme(idProgramme);

        if(nombredeCreditDuProgramme == 0 || nombredeCreditDuProgramme == null){
            return pourcentage =0;
        }else
            return pourcentage = nombreDeCreditCompletes /nombredeCreditDuProgramme*100;
    }

    @Override
    public Integer findNombreDeCoursRestants(Integer idEtudiant, Integer idProgramme) {
        return coursProgrammeService.findNombreDeCoursByProgramme(idProgramme) -
                FindNombreDeCoursCompletedByEtudiantByProgramme(idEtudiant ,idProgramme)+
                FindNombreDeCoursAReprendreByEtudiantByProgramme( idEtudiant,  idProgramme);
    }
}
