package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.ExampleStudent;
import fdsa.edu.pnu.Repository.ExampleAddressRepository;
import fdsa.edu.pnu.Repository.ExampleStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleStudentService {

    @Autowired
    private ExampleStudentRepository exampleStudentRepository;

    @Autowired
    private ExampleAddressRepository exampleAddressRepository;

    public ExampleStudent saveStudent(ExampleStudent exampleStudent) {
        ExampleStudent s1 = exampleStudentRepository.save(exampleStudent);
        exampleStudent.getAddresses().forEach(a -> {
            a.setStudent(s1);
            exampleAddressRepository.save(a);
        });

        return exampleStudentRepository.findById(s1.getStudentId()).get();
    }

    public List<ExampleStudent> getStudent() {
        return (List<ExampleStudent>) exampleStudentRepository.findAll();
    }
}
