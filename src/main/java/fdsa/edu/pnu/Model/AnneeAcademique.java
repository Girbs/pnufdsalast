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

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@org.hibernate.annotations.Proxy(lazy = false)

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
    @OneToMany(mappedBy = "anneeAcademique", targetEntity = Semestre.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Semestre> semestre;

    public AnneeAcademique() {
    }


}
