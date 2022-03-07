package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter

@Table(name = "CoursEtudiant")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class CoursEtudiant implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_Cours_Etudiant_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_Cours_Etudiant_ID_GENERATOR", strategy = "native")
    private Integer id;
    private double note;
    private String mention;

    @JsonIgnoreProperties(value = {"coursEtudiants"}, allowSetters = true)
    @ManyToOne(targetEntity = Etudiant.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "CoursEtudiant"))
    private Etudiant etudiant;


    @JsonIgnoreProperties(value = {"coursEtudiants"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "coursId", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "CoursId"))
    private Cours cours;
}