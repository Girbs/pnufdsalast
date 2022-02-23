package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.LogTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTrackingDAO extends JpaRepository<LogTracking, Integer> {

}
