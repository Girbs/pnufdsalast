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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "HistoriqueEvaluation")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class HistoriqueEvaluation implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_HISTORIQUEEXAM_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_HISTORIQUEEXAM_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "Note", nullable = false, length = 10)
    private double note;

    @JsonIgnoreProperties(value = {"historiqueEvaluations"}, allowSetters = true)
    @ManyToOne(targetEntity = Evaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "evaluationID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_EVALUATIONS_Hevaluation"))
    private Evaluation evaluation;

    @Column(name = "lienFichier")
    private String lienFichier;

    @Column(name = "commentaire")
    private String commentaire;


    @JsonIgnoreProperties(value = {"historiqueEvaluations"}, allowSetters = true)
    @ManyToOne(targetEntity = CoursEtudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "cours_etudiant_id", referencedColumnName = "ID")})
    public CoursEtudiant coursEtudiant;

}
