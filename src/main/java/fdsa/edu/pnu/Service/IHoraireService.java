package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Cours;
import fdsa.edu.pnu.Model.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IHoraireService {
    List<Horaire> findAll();

    Optional<Horaire> findById(Integer id);

    Horaire save(Horaire horaire);

    void delete(Integer id);
}
