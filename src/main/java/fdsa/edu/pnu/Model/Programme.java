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
@Table(name = "Programme")
public class Programme implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PROGRAMME_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PROGRAMME_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "Sigle", nullable = true, length = 255)
    private String sigle;
    @Column(name = "Description", nullable = false, length = 255)
    private String description;
    @OneToMany(mappedBy = "programme", targetEntity = fdsa.edu.pnu.Model.Session.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set sessions = new java.util.HashSet();
    @ManyToMany(mappedBy = "programmes", targetEntity = fdsa.edu.pnu.Model.Etudiant.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set etudiants = new java.util.HashSet();

    public Programme() {
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

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String value) {
        this.sigle = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public java.util.Set getSessions() {
        return sessions;
    }

    public void setSessions(java.util.Set value) {
        this.sessions = value;
    }

    public java.util.Set getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(java.util.Set value) {
        this.etudiants = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
