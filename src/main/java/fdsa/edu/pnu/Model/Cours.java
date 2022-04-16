
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

@Table(name = "Cours")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Cours implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_COURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_COURS_ID_GENERATOR", strategy = "native")
    private int id;

    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @OneToMany(mappedBy = "cours", targetEntity = Evaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Evaluation> evaluation;

    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @ManyToOne(targetEntity = Session.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "sessionId", referencedColumnName = " ID", nullable = false)}, foreignKey = @ForeignKey(name = "Session_Cours"))
    private Session session;


    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @ManyToOne(targetEntity = CoursProgramme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursProgrammId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Couriculum_COURS"))
    private CoursProgramme coursProgramme;


    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @ManyToOne(targetEntity = Professeur.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "ProfesseurPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "Enseigner"))
    private Professeur professeur;

    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @OneToMany(mappedBy = "cours", targetEntity = Horaire.class)
    private List<Horaire> horaires;

    @OneToMany(mappedBy = "cours", targetEntity = Discussion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Discussion> discussions;


    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @OneToMany(mappedBy = "cours", targetEntity = CoursEtudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<CoursEtudiant> coursEtudiants;


    @Column(name = "Duree", nullable = true, length = 255)
    private String duree;

    @Column(name = "statut", nullable = true, length = 255)
    private String statut;

    @Column(name = "Responsable", nullable = true, length = 255)
    private String responsable;

}
