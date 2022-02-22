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

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`Session`")
public class Session implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_SESSION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_SESSION_ID_GENERATOR", strategy = "native")
    private int id;

    @ManyToOne(targetEntity = Programme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ProgrammeID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SESSIONS_PROGRAMMES"))
    private Programme programme;

    @Column(name = "DescriptionSession", nullable = true, length = 255)
    private String descriptionSession;

    @Column(name = "CodeSession", nullable = true, length = 255)
    private String codeSession;

    @Column(name = "Ordre", nullable = false, length = 10)
    private int ordre;

    @OneToMany(mappedBy = "session", targetEntity = Curriculum.class)
    private List<Curriculum> curriculum;

    public Session() {
    }

}
