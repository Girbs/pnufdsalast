package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="Curriculum")

public class Curriculum {
    @Column(name="ID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="PNU_CURRICULUM")
    @org.hibernate.annotations.GenericGenerator(name="PNU_DEPARTEMENT_ID_GENERATOR", strategy="native")
    private int id;

    private double nombreDeCredit;

    @ManyToOne(targetEntity= Matiere.class, fetch=FetchType.LAZY)
    @JoinColumns(value={ @JoinColumn(name="matiereId", referencedColumnName="ID", nullable=true) }, foreignKey=@ForeignKey(name="CoursProgramme"))
    @JsonBackReference
    private Matiere matiere;

    @ManyToOne(targetEntity= Programme.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="SessionID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FK_SESSIONS_Curriculum"))
    private Session session;

    @OneToMany(mappedBy="curriculum", targetEntity= Cours.class)
    private List<Cours> cours ;




}


