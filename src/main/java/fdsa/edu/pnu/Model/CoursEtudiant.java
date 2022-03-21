package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CoursEtudiant")

public class CoursEtudiant implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_Cours_Etudiant_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_Cours_Etudiant_ID_GENERATOR", strategy = "native")



    private Integer id;
    private double note;
    private String mention;
    private String cote;
    private double numbrePoint;
    private String type;

    @JsonIgnoreProperties(value = {"coursEtudiants"}, allowSetters = true)
    @ManyToOne(targetEntity = Etudiant.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "CoursEtudiant"))
    private Etudiant etudiant;


    @JsonIgnoreProperties(value = {"coursEtudiants"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class,  fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "coursId", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "CoursId"))
    private Cours cours;

    @JsonIgnoreProperties(value = {"coursEtudiant"}, allowSetters = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "coursEtudiant", fetch = FetchType.LAZY)
    private List<HistoriqueEvaluation> historiqueEvaluations;

}