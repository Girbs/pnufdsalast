package fdsa.edu.pnu.Repository;

import fdsa.edu.pnu.Model.ExampleStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleStudentRepository extends CrudRepository<ExampleStudent, Integer> {
}
