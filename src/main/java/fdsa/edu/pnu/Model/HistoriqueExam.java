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

@Entity
@Getter
@Setter
@Table(name = "HistoriqueExam")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class HistoriqueExam implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_HISTORIQUEEXAM_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_HISTORIQUEEXAM_ID_GENERATOR", strategy = "native")
    private int ID;
    @Column(name = "Note", nullable = false, length = 10)
    private double note;


    @JsonIgnoreProperties(value = {"historiqueExams"}, allowSetters = true)
    @ManyToOne(targetEntity =Etudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)})
    private Etudiant etudiant;

    @JsonIgnoreProperties(value = {"historiqueExams"}, allowSetters = true)
    @ManyToOne(targetEntity =Evaluation.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({@JoinColumn(name = "EvaluationID", referencedColumnName = "ID", nullable = false)})
    private Evaluation evaluation;



//    @JsonIgnoreProperties(value = {"historiqueExam"}, allowSetters = true)
//    @ManyToOne(targetEntity =Evaluation.class, fetch = FetchType.LAZY)
//    @JoinColumns(value = {@JoinColumn(name = "EvaluationID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "Evaluation_HistoriqueExamen"))
//    private Evaluation evaluation;

    public HistoriqueExam() {
    }

}
