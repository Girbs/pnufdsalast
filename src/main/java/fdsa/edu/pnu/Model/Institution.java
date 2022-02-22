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

import javax.persistence.*;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "Institution")
public class Institution implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_INSTITUTION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_INSTITUTION_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "NomInstitution", nullable = true, length = 255)
    private String nomInstitution;
    @Column(name = "Adresse", nullable = true, length = 255)
    private String adresse;
    @Column(name = "Telephone", nullable = true, length = 255)
    private String telephone;
    @OneToMany(mappedBy = "institution", targetEntity = Stage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set stages = new java.util.HashSet();

    public Institution() {
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

    public String getNomInstitution() {
        return nomInstitution;
    }

    public void setNomInstitution(String value) {
        this.nomInstitution = value;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String value) {
        this.adresse = value;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String value) {
        this.telephone = value;
    }

    public java.util.Set getStages() {
        return stages;
    }

    public void setStages(java.util.Set value) {
        this.stages = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
