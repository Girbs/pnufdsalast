/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 */

/**
 * Licensee: 
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "EvaluationOrdinaire")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class EvaluationOrdinaire extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EVALUATION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EVALUATION_ID_GENERATOR", strategy = "native")
    private int id;


    @JsonIgnoreProperties(value = {"evaluationOrdinaires"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_EVALUATIONS_COURS"))
    private Cours cours;

    @JsonIgnoreProperties(value = {"evaluationOrdinaires"}, allowSetters = true)
    @ManyToOne(targetEntity = Examen.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ExamenId", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "FK_EVALUATIONS_EXAMEN"))
    private Examen examen;




    @Column(name = "DateEvaluation", nullable = false)
    private java.sql.Timestamp dateEvaluation;

    @Column(name = "pourcentage", nullable = true)
    private double pourcentage;

    @Column(name = "TypeEvaluation", nullable = true, length = 255)
    private String typeEvaluation;

    @Column(name = "statutResultat", nullable = true, length = 255)
    private String statutResultat;


    @JsonIgnoreProperties(value = {"evaluationOrdinaire"}, allowSetters = true)
  //  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "evaluationOrdinaire", fetch = FetchType.LAZY)
    private List<HistoriqueEvaluationOrdinaire> historiqueEvaluationOrdinaires;

    public EvaluationOrdinaire() {
    }


}
