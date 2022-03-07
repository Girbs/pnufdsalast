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
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
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
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "Etudiant")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Etudiants")
public class Etudiant extends Utilisateur implements Serializable {

    @Column(name = "CodeEtudiant")
    private String codeEtudiant;

    @Column(name = "Matricule")
    private String matricule;



    @ManyToMany(targetEntity = Promotion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Promotion_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "PromotionID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set promotions;

    @JsonIgnoreProperties(value = {"etudiant"}, allowSetters = true)
    @ManyToMany(targetEntity = Programme.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Programme_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "ProgrammeID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Programme> programmes;



//    @OneToOne(mappedBy = "etudiant", targetEntity = HistoriqueExam.class)
//    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
//    private HistoriqueExam historiqueExam;

    @JsonIgnoreProperties(value = {"etudiant"}, allowSetters = true)
    @OneToMany(mappedBy = "etudiant", targetEntity = HistoriqueExam.class)
    private List<HistoriqueExam> historiqueExams;


    @JsonIgnoreProperties(value = {"etudiant"}, allowSetters = true)
    @OneToMany(mappedBy = "etudiant", targetEntity = Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Paiement> paiements;

    @JsonIgnoreProperties(value = {"etudiant"}, allowSetters = true)
    @OneToMany(mappedBy = "etudiant", targetEntity = CoursEtudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<CoursEtudiant> coursEtudiants;

    @JsonIgnoreProperties(value = {"etudiant"}, allowSetters = true)
    @OneToMany(mappedBy = "etudiant", targetEntity = Stage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Stage> stages;

    @OneToMany(mappedBy = "etudiant", targetEntity = Requete.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set requetes;

    @OneToMany(mappedBy = "etudiant", targetEntity = Message.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set messages;

    public Etudiant() {

    }




}
