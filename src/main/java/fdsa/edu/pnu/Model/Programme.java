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

@Table(name = "Programme")
public class Programme implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PROGRAMME_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PROGRAMME_ID_GENERATOR", strategy = "native")
    private int id;

    @Column(name = "Sigle", nullable = true, length = 255)
    private String sigle;

    @Column(name = "Description", nullable = false, length = 255)
    private String description;

    @OneToMany(mappedBy = "programme", targetEntity = Session.class)
    private List<Session> sessions;


    @OneToMany(mappedBy = "programme", targetEntity = Session.class)
    private List<Programme> programmes;


    @ManyToMany(mappedBy = "programmes", targetEntity = Etudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Etudiant> etudiants;

    public Programme() {
    }
}
