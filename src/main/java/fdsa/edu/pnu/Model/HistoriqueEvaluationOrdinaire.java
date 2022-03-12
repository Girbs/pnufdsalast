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
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "HistoriqueEvaluationOrdinaire")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class HistoriqueEvaluationOrdinaire implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_HISTORIQUEEXAM_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_HISTORIQUEEXAM_ID_GENERATOR", strategy = "native")
    private int ID;
    @Column(name = "Note", nullable = false, length = 10)
    private double note;

    @JsonIgnoreProperties(value = {"historiqueEvaluationOrdinaires"}, allowSetters = true)
    @ManyToOne(targetEntity = EvaluationOrdinaire.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value ={@JoinColumn(name = "EvaluationOrdinaireID", referencedColumnName = "ID", nullable = false)},foreignKey = @ForeignKey(name = "HistoriqueEvaluationOrdinaireEvaluationOrdinaire"))
    private EvaluationOrdinaire evaluationOrdinaire;

    @ManyToOne(targetEntity = CoursEtudiant.class, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"historiqueEvaluationOrdinaires"}, allowSetters = true)
    @JoinColumns(value = {@JoinColumn(name = "cours_etudiant_id", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "historiqueEvaluationOrdinairesCoursEtudiant"))
    private CoursEtudiant coursEtudiant;


    public HistoriqueEvaluationOrdinaire() {
    }

}
