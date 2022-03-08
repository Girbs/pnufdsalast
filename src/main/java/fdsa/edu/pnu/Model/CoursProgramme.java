package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CoursProgramme")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class CoursProgramme {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_CURRICULUM")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_DEPARTEMENT_ID_GENERATOR", strategy = "native")
    private int id;

    private double nombreDeCredit;
    @JsonIgnoreProperties(value = {"coursProgrammes"}, allowSetters = true)
    @ManyToOne(targetEntity = Matiere.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "matiereId", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "CoursProgrammes"))

    private Matiere matiere;

    @JsonIgnoreProperties(value = {"coursProgrammes"}, allowSetters = true)
    @ManyToOne(targetEntity = SessionProgramme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SessionId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SESSIONS_CoursProgramme"))
    private SessionProgramme sessionProgramme;

    @JsonIgnoreProperties(value = {"coursProgramme"}, allowSetters = true)
    @OneToMany(mappedBy = "coursProgramme", targetEntity = Cours.class)
    private List<Cours> cours;

    @JsonIgnoreProperties(value = {"coursProgramme"}, allowSetters = true)
    @OneToMany(mappedBy = "coursProgramme", targetEntity = EvaluationExtraordinaire.class)
    private List<EvaluationExtraordinaire> evaluationExtraordinaireList;
}


