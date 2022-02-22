package fdsa.edu.pnu.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Semestre")
@Data
public class Semestre implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_CONCOURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_CONCOURS_ID_GENERATOR", strategy = "native")
    private Integer id;
    @Column(name = "DateDebut", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date DateDebut;
    @Column(name = "DateFin", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date DateFin;
    @Column(name = "Description", nullable = true, length = 255)
    private String description;

    @Column(name = "status", nullable = true, length = 255)
    private String status;

    @OneToMany(mappedBy = "semestre", targetEntity = Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Paiement> paiement;

    @ManyToOne(targetEntity = AnneeAcademique.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "AnneeAcademiqueID", referencedColumnName = " ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Semestre_AnneeAcademique"))
    private AnneeAcademique anneeAcademique;


    @OneToMany(mappedBy = "semestre", targetEntity = Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Cours> cours;

}
