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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Cours")
public class Cours implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_COURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_COURS_ID_GENERATOR", strategy = "native")
    private int id;

    @OneToOne(targetEntity = fdsa.edu.pnu.Model.Professeur.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ProfesseurPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "Enseigner"))
    private fdsa.edu.pnu.Model.Professeur professeur;

    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Matiere.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "MatiereID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "FK_Matiere_Cours"))
    private fdsa.edu.pnu.Model.Matiere matiere;

    @Column(name = "CodeCours", nullable = true, length = 255)
    private String codeCours;

    @Column(name = "DescriptionCours", nullable = true, length = 255)
    private String descriptionCours;

    @Column(name = "MatiereDesc", nullable = true, length = 255)
    private String matiereDesc;

    @Column(name = "CreditReel", nullable = true, length = 10)
    private int creditReel;

    @Column(name = "Duree", nullable = true, length = 255)
    private String duree;

    @Column(name = "Responsable", nullable = true, length = 255)
    private String responsable;

    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Semestre.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SemestreId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SEMESTRE_COURS"))
    private fdsa.edu.pnu.Model.Semestre semestre;

    @OneToMany(mappedBy = "cours", targetEntity = fdsa.edu.pnu.Model.Evaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set evaluations = new java.util.HashSet();

    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Session.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SessionId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SESSION_COURS"))
    private fdsa.edu.pnu.Model.Session session;

    @ManyToMany(mappedBy = "cours", targetEntity = fdsa.edu.pnu.Model.Etudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set etudiants = new java.util.HashSet();

    @OneToMany(mappedBy = "cours", targetEntity = fdsa.edu.pnu.Model.Horaire.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set horaires = new java.util.HashSet();

    @OneToMany(mappedBy = "cours", targetEntity = fdsa.edu.pnu.Model.Discussion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set discussions = new java.util.HashSet();


}
