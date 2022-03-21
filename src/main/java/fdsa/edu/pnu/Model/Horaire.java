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
@Setter
@Getter
@Entity
@Table(name = "Horaire")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Horaire implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_HORAIRE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_HORAIRE_ID_GENERATOR", strategy = "native")
    private int ID;

    @JsonIgnoreProperties(value = {"horaires"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "HoraireCours"))
    private Cours cours;

    @Column(name = "Jour", nullable = true, length = 255)
    private String jour;
    @Column(name = "Heure", nullable = true, length = 255)
    private String heure;
    @Column(name = "DatePremierCours", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date datePremierCours;

    public Horaire() {
    }


}

