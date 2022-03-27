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
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class CoursEtudiant implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
    @ManyToOne(targetEntity = Cours.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "coursId", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "CoursId"))
    private Cours cours;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties(value = {"coursEtudiant"}, allowSetters = true)
    @OneToMany(mappedBy = "coursEtudiant", targetEntity = HistoriqueEvaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<HistoriqueEvaluation> historiqueEvaluations;

}