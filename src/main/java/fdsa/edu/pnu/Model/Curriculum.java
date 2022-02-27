package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Curriculum")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Curriculum {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_CURRICULUM")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_DEPARTEMENT_ID_GENERATOR", strategy = "native")
    private int id;

    private double nombreDeCredit;
    @JsonIgnoreProperties(value = {"curriculum"}, allowSetters = true)
    @ManyToOne(targetEntity = Matiere.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "matiereId", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "CoursProgramme"))
    private Matiere matiere;

    @JsonIgnoreProperties(value = {"curriculum"}, allowSetters = true)
    @ManyToOne(targetEntity = SessionProgramme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SessionId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SESSIONS_Curriculum"))
    private SessionProgramme session;

    @JsonIgnoreProperties(value = {"curriculum"}, allowSetters = true)
    @OneToMany(mappedBy = "curriculum", targetEntity = Cours.class)
    private List<Cours> cours;


}


