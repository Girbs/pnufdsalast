package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Session")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Session implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_CONCOURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_CONCOURS_ID_GENERATOR", strategy = "native")
    private Integer id;
    @Column(name = "DateDebut", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date dateDebut;
    @Column(name = "DateFin", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date dateFin;
    @Column(name = "Description", nullable = true, length = 255)
    private String description;

    @Column(name = "status", nullable = true, length = 255)
    private String status;

    @OneToMany(mappedBy = "session", targetEntity = Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Paiement> paiement;

    @JsonIgnoreProperties(value = {"session"}, allowSetters = true)
    @OneToMany(mappedBy = "session", targetEntity = Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Cours> cours;


    @JsonIgnoreProperties(value = {"session"}, allowSetters = true)
    @ManyToOne(targetEntity = AnneeAcademique.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "AnneeAcademiqueID", referencedColumnName = " ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Session_AnneeAcademique"))
    private AnneeAcademique anneeAcademique;


}
