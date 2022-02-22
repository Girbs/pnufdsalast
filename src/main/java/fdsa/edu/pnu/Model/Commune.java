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
@Table(name = "Commune")
public class Commune implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_COMMUNE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_COMMUNE_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = DepartementGeographique.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "DepartementGeographiqueID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "appartenir"))
    private DepartementGeographique departementGeographique;
    @Column(name = "Description", nullable = true, length = 255)
    private String description;
    @OneToMany(mappedBy = "commune", targetEntity = Personne.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set personne = new java.util.HashSet();

    public Commune() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public DepartementGeographique getDepartementGeographique() {
        return departementGeographique;
    }

    public void setDepartementGeographique(DepartementGeographique value) {
        this.departementGeographique = value;
    }

    public java.util.Set getPersonne() {
        return personne;
    }

    public void setPersonne(java.util.Set value) {
        this.personne = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
