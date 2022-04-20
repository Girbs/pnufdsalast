package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Programme;

import java.util.List;

public interface IProgrammeService {
    List<Programme> findAll();

    Programme findById(Integer id);

    Programme save(Programme programme);

    Programme update(Integer id, Programme programme);

    void delete(Integer id);
    List<Programme> FindListProgrammeByIdEtudiant( Integer idEtudiant);
}
