package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.AnneeAcademique;

import java.util.List;
import java.util.Optional;

public interface IAnneeAcademiqueService {

    List<AnneeAcademique> findAll();

    Optional<AnneeAcademique> findById(Integer id);

    AnneeAcademique save(AnneeAcademique anneeAcademique);

    AnneeAcademique update(Integer id, AnneeAcademique anneeAcademique);

    void delete(Integer id);

}
