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
@Table(name = "TypePaiement")
public class TypePaiement implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_TYPEPAIEMENT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_TYPEPAIEMENT_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "Type", nullable = true, length = 255)
    private String type;
    @Column(name = "Description", nullable = true, length = 255)
    private String description;
    @OneToMany(mappedBy = "typePaiement", targetEntity = Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiements = new java.util.HashSet();

    public TypePaiement() {
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

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public java.util.Set getPaiements() {
        return paiements;
    }

    public void setPaiements(java.util.Set value) {
        this.paiements = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
