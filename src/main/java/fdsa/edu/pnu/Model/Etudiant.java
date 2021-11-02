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
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Etudiant")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Etudiants")
public class Etudiant extends Utilisateur implements Serializable {


    @Column(name = "CodeEtudiant")
    private String codeEtudiant;

    @Column(name = "Matricule")
    private String matricule;

    @OneToMany(mappedBy = "etudiant", targetEntity = PaiementSession.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiementSessions;

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

    @OneToOne(mappedBy = "etudiant", targetEntity = HistoriqueExam.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private HistoriqueExam historiqueExam;

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
        this.paiementSessions = paiementSessions;
        this.cours = cours;
        this.promotions = promotions;
        this.programmes = programmes;
        this.historiqueExam = historiqueExam;
        this.paiements = paiements;
        this.stages = stages;
        this.requetes = requetes;
        this.messages = messages;
    }

    public String getCodeEtudiant() {
        return codeEtudiant;
    }

    public void setCodeEtudiant(String codeEtudiant) {
        this.codeEtudiant = codeEtudiant;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Set getPaiementSessions() {
        return paiementSessions;
    }

    public void setPaiementSessions(Set paiementSessions) {
        this.paiementSessions = paiementSessions;
    }

    public Set getCours() {
        return cours;
    }

    public void setCours(Set cours) {
        this.cours = cours;
    }

    public Set getPromotions() {
        return promotions;
    }

    public void setPromotions(Set promotions) {
        this.promotions = promotions;
    }

    public Set getProgrammes() {
        return programmes;
    }

    public void setProgrammes(Set programmes) {
        this.programmes = programmes;
    }

    public HistoriqueExam getHistoriqueExam() {
        return historiqueExam;
    }

    public void setHistoriqueExam(HistoriqueExam historiqueExam) {
        this.historiqueExam = historiqueExam;
    }

    public Set getPaiements() {
        return paiements;
    }

    public void setPaiements(Set paiements) {
        this.paiements = paiements;
    }

    public Set getStages() {
        return stages;
    }

    public void setStages(Set stages) {
        this.stages = stages;
    }

    public Set getRequetes() {
        return requetes;
    }

    public void setRequetes(Set requetes) {
        this.requetes = requetes;
    }

    public Set getMessages() {
        return messages;
    }

    public void setMessages(Set messages) {
        this.messages = messages;
    }
}
