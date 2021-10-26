package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.ExampleStudent;
import fdsa.edu.pnu.ServiceImpl.ExampleStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleStudentController {

    @Autowired
    private ExampleStudentService exampleStudentService;

    @PostMapping({"/saveStudent"})
    public ExampleStudent saveStudent(@RequestBody ExampleStudent exampleStudent) {
        return exampleStudentService.saveStudent(exampleStudent);
    }

    @GetMapping({"/getStudent"})
    public List<ExampleStudent> getStudent() {
        return exampleStudentService.getStudent();
    }
}
