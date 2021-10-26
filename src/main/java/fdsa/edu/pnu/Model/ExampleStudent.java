package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "example_student")
public class ExampleStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentName;
    private Double studentPercentage;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ExampleAddress> addresses;

    @JsonManagedReference
    public List<ExampleAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<ExampleAddress> addresses) {
        this.addresses = addresses;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(Double studentPercentage) {
        this.studentPercentage = studentPercentage;
    }
}
