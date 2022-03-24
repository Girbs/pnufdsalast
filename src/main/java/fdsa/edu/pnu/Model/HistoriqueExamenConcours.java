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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "HistoriqueExamenConcours")
public class HistoriqueExamenConcours implements Serializable {

    @JsonIgnoreProperties(value = {"historiqueExamenConcours"}, allowSetters = true)
    @ManyToOne(targetEntity = PlannificationConcours.class)
    @JoinColumns({@JoinColumn(name = "PlannificationConcoursID", referencedColumnName = "ID")})
    public PlannificationConcours plannificationConcours;

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_HISTORIQUEEXAMENCONCOURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_HISTORIQUEEXAMENCONCOURS_ID_GENERATOR", strategy = "native")
    private int ID;
    @Column(name = "NoteObtenue", nullable = false, length = 10)
    private double noteObtenue;

    @JsonIgnoreProperties(value = {"historiqueExamenConcourss"}, allowSetters = true)
    @ManyToOne(targetEntity = Postulant.class)
    @JoinColumns({@JoinColumn(name = "PostulantID", referencedColumnName = "ID")})
    private Postulant postulant;

}
