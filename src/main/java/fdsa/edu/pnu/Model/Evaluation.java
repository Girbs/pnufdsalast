/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "Evaluation")
public class Evaluation implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EVALUATION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EVALUATION_ID_GENERATOR", strategy = "native")
    private int id;

    @JsonIgnoreProperties(value = {"evaluations"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_EVALUATIONS_COURS"))
    private Cours cours;

    @Column(name = "DateEvaluation", nullable = false)
    private java.sql.Timestamp dateEvaluation;
    @Column(name = "`SessionProgramme`", nullable = true, length = 255)
    private String session;
    @Column(name = "CotationPourcentage", nullable = true, precision = 19, scale = 0)
    private java.math.BigDecimal cotationPourcentage;
    @Column(name = "TypeEvaluation", nullable = true, length = 255)
    private String typeEvaluation;


    @JsonIgnoreProperties(value = {"evaluation"}, allowSetters = true)
    @OneToMany(mappedBy = "evaluation", targetEntity = HistoriqueExam.class)
    private List<HistoriqueExam> historiqueExams;

//    @JsonIgnoreProperties(value = {"evaluation"}, allowSetters = true)
//    @OneToMany(mappedBy = "evaluation", targetEntity = HistoriqueExam.class)
//    private HistoriqueExam historiqueExam;

//    @OneToOne(mappedBy = "evaluation", targetEntity = HistoriqueExam.class)
//    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
//    private HistoriqueExam historiqueExam;

    public Evaluation() {
    }


}
