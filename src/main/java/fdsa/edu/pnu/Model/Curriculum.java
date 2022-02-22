package fdsa.edu.pnu.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Curriculum")

public class Curriculum {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_CURRICULUM")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_DEPARTEMENT_ID_GENERATOR", strategy = "native")
    private int id;

    private double nombreDeCredit;

    @ManyToOne(targetEntity = Matiere.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "matiereId", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "CoursProgramme"))
    private Matiere matiere;


    @ManyToOne(targetEntity = SessionProgramme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SessionId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SESSIONS_Curriculum"))
    private SessionProgramme session;

    @OneToMany(mappedBy = "curriculum", targetEntity = Cours.class)
    private List<Cours> cours;


}


