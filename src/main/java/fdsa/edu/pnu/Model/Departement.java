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
 */

/**
 * Licensee: 
 * License Type: EvaluationOrdinaire
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
@Table(name = "Departement")
public class Departement implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_DEPARTEMENT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_DEPARTEMENT_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "Nom", nullable = true, length = 255)
    private String nom;
    @Column(name = "Description", nullable = true, length = 255)
    private String Description;
    @OneToMany(mappedBy = "departement", targetEntity = Fonction.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set fonction = new java.util.HashSet();

    public Departement() {
    }

    public int getId() {
        return id;
    }

    private void setId(int value) {
        this.id = value;
    }

    public int getORMID() {
        return getId();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String value) {
        this.Description = value;
    }

    public java.util.Set getFonction() {
        return fonction;
    }

    public void setFonction(java.util.Set value) {
        this.fonction = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
