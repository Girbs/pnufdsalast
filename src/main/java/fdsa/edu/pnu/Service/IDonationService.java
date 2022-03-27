package fdsa.edu.pnu.Service;

import fdsa.edu.pnu.Model.Donation;

import java.util.List;
import java.util.Optional;

public interface IDonationService {
    List<Donation> findAll();
    Optional<Donation> findById(Integer id);
    Donation save(Donation donation);
    void delete(Integer id);
}
