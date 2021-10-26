package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.ExampleAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleAddressRepository extends CrudRepository<ExampleAddress, Integer> {
}
