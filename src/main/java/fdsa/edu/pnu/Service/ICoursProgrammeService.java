package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.CoursProgramme;

import java.util.List;

public interface ICoursProgrammeService {
    List<CoursProgramme> findAll();

    CoursProgramme findById(Integer id);

    CoursProgramme save(CoursProgramme coursProgramme);

    CoursProgramme update(Integer id, CoursProgramme coursProgramme);

    void delete(Integer id);
}
