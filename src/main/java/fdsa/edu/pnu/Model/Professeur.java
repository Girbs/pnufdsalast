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

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Professeur")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Professeurs")
public class Professeur extends fdsa.edu.pnu.Model.Utilisateur implements Serializable {
    @Column(name = "CodeProfesseur", nullable = true, length = 255)
    private String codeProfesseur;
    @Column(name = "Titre", nullable = true, length = 255)
    private String titre;
    @Column(name = "LienCv", nullable = true, length = 255)
    private String lienCv;
    @OneToOne(mappedBy = "professeur", targetEntity = fdsa.edu.pnu.Model.Cours.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private fdsa.edu.pnu.Model.Cours cours;
    @OneToMany(mappedBy = "professeur", targetEntity = fdsa.edu.pnu.Model.Publication.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set publications = new java.util.HashSet();

    public Professeur() {
    }

    public String getCodeProfesseur() {
        return codeProfesseur;
    }

    public void setCodeProfesseur(String value) {
        this.codeProfesseur = value;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String value) {
        this.titre = value;
    }

    public String getLienCv() {
        return lienCv;
    }

    public void setLienCv(String value) {
        this.lienCv = value;
    }

    public fdsa.edu.pnu.Model.Cours getCours() {
        return cours;
    }

    public void setCours(fdsa.edu.pnu.Model.Cours value) {
        this.cours = value;
    }

    public java.util.Set getPublications() {
        return publications;
    }

    public void setPublications(java.util.Set value) {
        this.publications = value;
    }

    public String toString() {
        return super.toString();
    }

}
