package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Evaluation")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Evaluation extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EVALUATION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EVALUATION_ID_GENERATOR", strategy = "native")
    private int id;


    @JsonIgnoreProperties(value = {"evaluation"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_EVALUATIONS_COURS"))
    private Cours cours;

    @JsonIgnoreProperties(value = {"evaluation"}, allowSetters = true)
    @ManyToOne(targetEntity = OrganisationExamen.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "OrganisationExamenId", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "FKOrganisationExamen"))
    private OrganisationExamen organisationExamen;




    @Column(name = "DateEvaluation", nullable = false)
    private java.sql.Timestamp dateEvaluation;

    @Column(name = "pourcentage", nullable = true)
    private double pourcentage;

    @Column(name = "TypeEvaluation", nullable = true, length = 255)
    private String typeEvaluation;

    @Column(name = "statutResultat", nullable = true, length = 255)
    private String statutResultat;

//
//    @JsonIgnoreProperties(value = {"evaluation"}, allowSetters = true)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToMany(mappedBy = "evaluation", fetch = FetchType.EAGER)
//    private List<HistoriqueEvaluation> historiqueEvaluations;

    @JsonIgnoreProperties(value = {"evaluation"}, allowSetters = true)
    @OneToMany(mappedBy = "evaluation", targetEntity = HistoriqueEvaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<HistoriqueEvaluation> historiqueEvaluations;

    public Evaluation() {
    }

}


