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
@Table(name = "TypeRequete")
public class TypeRequete implements Serializable {
    @Column(name = "ID", nullable = false, length = 255)
    @Id
    private String type;
    @OneToMany(mappedBy = "typeRequete", targetEntity = Requete.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set requetes = new java.util.HashSet();
    @Transient
    private boolean _saved = false;

    public TypeRequete() {
    }

    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof TypeRequete))
            return false;
        TypeRequete typerequete = (TypeRequete) aObj;
        return (getType() == null || getType().equals(typerequete.getType())) && (getType() != null || typerequete.getType() == null);
    }

    public int hashCode() {
        int hashcode = 0;
        hashcode = hashcode + (getType() == null ? 0 : getType().hashCode());
        return hashcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getORMID() {
        return getType();
    }

    public java.util.Set getRequetes() {
        return requetes;
    }

    public void setRequetes(java.util.Set value) {
        this.requetes = value;
    }

    public String toString() {
        return String.valueOf(getType());
    }

    public void onSave() {
        _saved = true;
    }


    public void onLoad() {
        _saved = true;
    }


    public boolean isSaved() {
        return _saved;
    }


}
