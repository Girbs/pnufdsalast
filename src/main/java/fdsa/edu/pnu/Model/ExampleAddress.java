package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "example_address")
public class ExampleAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String address;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private ExampleStudent student;

    @JsonBackReference
    public ExampleStudent getStudent() {
        return student;
    }

    public void setStudent(ExampleStudent student) {
        this.student = student;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
