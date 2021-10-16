package fdsa.edu.pnu.Model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Semestre implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_SEMESTRE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_SEMESTRE_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "codeSemestre", nullable = false, length = 255)
    private String codeSemestre;
    @Column(name = "Description", nullable = false, length = 255)
    private String description;
    @Column(name = "Debut", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date debut;
    @Column(name = "Fin", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date fin;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.AnneeAcademique.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "AnneeAcademiqueId", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "FK_AnneeAcademique_Session"))
    private fdsa.edu.pnu.Model.AnneeAcademique anneeAcademiques;

}
