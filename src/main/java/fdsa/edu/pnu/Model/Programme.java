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
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
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
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Programme")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
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


    @JsonIgnoreProperties(value = {"programme"}, allowSetters = true)
    @OneToMany(mappedBy = "programme", targetEntity = SessionProgramme.class)
    private List<SessionProgramme> sessionProgrammeList;

    @JsonIgnoreProperties(value = {"programme"}, allowSetters = true)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProgrammePrerequis")
    private Programme prerequis;

    @JsonIgnoreProperties(value = {"prerequis"}, allowSetters = true)
    @OneToMany(mappedBy = "prerequis", targetEntity = Programme.class)
    private List<Programme> programmes;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties(value = {"programme"}, allowSetters = true)
    @OneToMany(mappedBy = "programme", targetEntity = ProgrammeEtudiant.class)
    private List<ProgrammeEtudiant> programmesEtudiant;


    public Programme() {
    }
}
