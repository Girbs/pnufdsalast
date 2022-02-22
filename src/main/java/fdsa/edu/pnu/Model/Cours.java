/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cours implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_COURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_COURS_ID_GENERATOR", strategy = "native")
    private int id;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
//	@JsonIgnoreProperties("car")
//	private List<Driver> drivers;


    @OneToMany(mappedBy = "cours", targetEntity = Evaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Evaluation> evaluations;

    @ManyToOne(targetEntity = Semestre.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SemestreId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Semestre_COURS"))
    private Semestre semestre;

    @ManyToOne(targetEntity = Curriculum.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CurriculumId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Couriculum_COURS"))
    private Curriculum curriculum;

    @ManyToOne(targetEntity = Professeur.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "ProfesseurPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "Enseigner"))
    private Professeur professeur;

    @ManyToMany(mappedBy = "cours", targetEntity = Etudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "cours", targetEntity = Horaire.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Horaire> horaires;

    @OneToMany(mappedBy = "cours", targetEntity = Discussion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Discussion> discussions;

    //	@Column(name="CreditReel", nullable=true, length=10)
//	private int creditReel;

    @Column(name = "Duree", nullable = true, length = 255)
    private String duree;

    @Column(name = "Responsable", nullable = true, length = 255)
    private String responsable;

}
