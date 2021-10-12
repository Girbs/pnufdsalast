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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name = "PlannificationConcours")
public class PlannificationConcours implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PLANNIFICATIONCONCOURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PLANNIFICATIONCONCOURS_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Concours.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ConcoursID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "ConcoursPlannificationConCours"))
    private fdsa.edu.pnu.Model.Concours concours;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Matiere.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "MatiereID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "Concerner"))
    private fdsa.edu.pnu.Model.Matiere matiere;
    @Column(name = "`Date`", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date Date;
    @Column(name = "Quotation", nullable = false, length = 10)
    private double quotation;
    @Column(name = "NoteDePassage", nullable = false, length = 10)
    private double noteDePassage;
    @OneToMany(mappedBy = "plannificationConcours", targetEntity = fdsa.edu.pnu.Model.HistoriqueExamenConcours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private Collection<HistoriqueExamenConcours> historiqueExamenConcours;

    public PlannificationConcours() {
    }


}
