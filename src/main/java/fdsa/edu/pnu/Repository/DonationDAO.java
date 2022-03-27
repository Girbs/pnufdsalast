package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationDAO extends JpaRepository<Donation, Integer> {
}
