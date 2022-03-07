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
 */

/**
 * Licensee: 
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
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
    @OneToMany(mappedBy = "cours", targetEntity = EvaluationOrdinaire.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<EvaluationOrdinaire> evaluationOrdinaires;

    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @ManyToOne(targetEntity = Session.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "sessionId", referencedColumnName = " ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Session_Cours"))
    private Session session;


    @JsonIgnoreProperties(value = {"cours"}, allowSetters = true)
    @ManyToOne(targetEntity = CoursProgramme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CurriculumId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Couriculum_COURS"))
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
    @OneToMany(mappedBy = "cours", targetEntity = CoursEtudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<CoursEtudiant> coursEtudiants;

    //	@Column(name="CreditReel", nullable=true, length=10)
//	private int creditReel;

    @Column(name = "Duree", nullable = true, length = 255)
    private String duree;

    @Column(name = "Responsable", nullable = true, length = 255)
    private String responsable;

}
