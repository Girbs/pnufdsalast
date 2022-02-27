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
 * <p>
 * Licensee:
 * License Type: Evaluation
 * <p>
 * Licensee:
 * License Type: Evaluation
 * <p>
 * Licensee:
 * License Type: Evaluation
 * <p>
 * Licensee:
 * License Type: Evaluation
 * <p>
 * Licensee:
 * License Type: Evaluation
 * <p>
 * Licensee:
 * License Type: Evaluation
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
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "Etudiant")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Etudiants")
public class Etudiant extends Utilisateur implements Serializable {

    @Column(name = "CodeEtudiant")
    private String codeEtudiant;

    @Column(name = "Matricule")
    private String matricule;

    @ManyToMany(targetEntity = Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Cours_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "CoursID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set cours;

    @ManyToMany(targetEntity = Promotion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Promotion_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "PromotionID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set promotions;

    @ManyToMany(targetEntity = Programme.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Programme_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "ProgrammeID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set programmes;

//    @OneToOne(mappedBy = "etudiant", targetEntity = HistoriqueExam.class)
//    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
//    private HistoriqueExam historiqueExam;

    @JsonIgnoreProperties(value = {"etudiant"}, allowSetters = true)
    @OneToMany(mappedBy = "etudiant", targetEntity = HistoriqueExam.class)
    private List<HistoriqueExam> historiqueExams;

    @OneToMany(mappedBy = "etudiant", targetEntity = Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiements;

    @OneToMany(mappedBy = "etudiant", targetEntity = Stage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set stages;

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

    public Etudiant(String codeEtudiant, String matricule, Set paiementSessions, Set cours, Set promotions, Set programmes, HistoriqueExam historiqueExam, Set paiements, Set stages, Set requetes, Set messages) {
        this.codeEtudiant = codeEtudiant;
        this.matricule = matricule;
        this.cours = cours;
        this.promotions = promotions;
        this.programmes = programmes;
        //  this.historiqueExam = historiqueExam;
        this.paiements = paiements;
        this.stages = stages;
        this.requetes = requetes;
        this.messages = messages;
    }


}
