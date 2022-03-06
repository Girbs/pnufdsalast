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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "AnneeAcademique")
public class AnneeAcademique implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_ANNEEACADEMIQUE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_ANNEEACADEMIQUE_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "Debut", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date debut;
    @Column(name = "Fin", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date fin;

    @JsonIgnoreProperties(value = {"anneeAcademique"}, allowSetters = true)
    @OneToMany(mappedBy = "anneeAcademique", targetEntity = Session.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Session> session;

    public AnneeAcademique() {
    }


}
