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
@Table(name = "Fonction")
public class Fonction implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_FONCTION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_FONCTION_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Departement.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "DepartementID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "FonctionDepartment"))
    private fdsa.edu.pnu.Model.Departement departement;
    @Column(name = "Titre", nullable = true, length = 255)
    private String titre;
    @OneToMany(mappedBy = "fonctionpersonel", targetEntity = fdsa.edu.pnu.Model.Personnel.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set fonctionpersonel = new java.util.HashSet();

    public Fonction() {
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String value) {
        this.titre = value;
    }

    public fdsa.edu.pnu.Model.Departement getDepartement() {
        return departement;
    }

    public void setDepartement(fdsa.edu.pnu.Model.Departement value) {
        this.departement = value;
    }

    public java.util.Set getFonctionpersonel() {
        return fonctionpersonel;
    }

    public void setFonctionpersonel(java.util.Set value) {
        this.fonctionpersonel = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
