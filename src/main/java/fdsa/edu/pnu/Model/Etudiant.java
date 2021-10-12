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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Etudiant")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Etudiants")
public class Etudiant extends fdsa.edu.pnu.Model.Utilisateur implements Serializable {


    @Column(name = "CodeEtudiant")
    private String codeEtudiant;

    @Column(name = "Matricule")
    private String matricule;

    @OneToMany(mappedBy = "etudiant", targetEntity = fdsa.edu.pnu.Model.PaiementSession.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiementSessions = new java.util.HashSet();

    @ManyToMany(targetEntity = fdsa.edu.pnu.Model.Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Cours_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "CoursID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set cours = new java.util.HashSet();

    @ManyToMany(targetEntity = fdsa.edu.pnu.Model.Promotion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Promotion_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "PromotionID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set promotions = new java.util.HashSet();

    @ManyToMany(targetEntity = fdsa.edu.pnu.Model.Programme.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name = "Programme_Etudiant", joinColumns = {@JoinColumn(name = "EtudiantPersonneID")}, inverseJoinColumns = {@JoinColumn(name = "ProgrammeID")})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set programmes = new java.util.HashSet();

    @OneToOne(mappedBy = "etudiant", targetEntity = fdsa.edu.pnu.Model.HistoriqueExam.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private fdsa.edu.pnu.Model.HistoriqueExam historiqueExam;

    @OneToMany(mappedBy = "etudiant", targetEntity = fdsa.edu.pnu.Model.Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiements = new java.util.HashSet();

    @OneToMany(mappedBy = "etudiant", targetEntity = fdsa.edu.pnu.Model.Stage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set stages = new java.util.HashSet();

    @OneToMany(mappedBy = "etudiant", targetEntity = fdsa.edu.pnu.Model.Requete.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set requetes = new java.util.HashSet();

    @OneToMany(mappedBy = "etudiant", targetEntity = fdsa.edu.pnu.Model.Message.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set messages = new java.util.HashSet();


}
