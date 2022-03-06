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
@Setter
@Getter
@Entity
@Table(name = "SessionProgramme")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class SessionProgramme implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_SESSION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_SESSION_ID_GENERATOR", strategy = "native")
    private int id;


    @JsonIgnoreProperties(value = {"sessionProgrammeList"}, allowSetters = true)
    @ManyToOne(targetEntity = Programme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ProgrammeID", referencedColumnName = "ID", nullable = false)})
    private Programme programme;

    @Column(name = "DescriptionSession", nullable = true, length = 255)
    private String descriptionSession;

    @Column(name = "CodeSession", nullable = true, length = 255)
    private String codeSession;

    @Column(name = "Ordre", nullable = false, length = 10)
    private int ordre;

    @JsonIgnoreProperties(value = {"sessionProgramme"}, allowSetters = true)
    @OneToMany(mappedBy = "sessionProgramme", targetEntity = CoursProgramme.class)
    private List<CoursProgramme> coursProgrammes;


    public SessionProgramme() {
    }

}
