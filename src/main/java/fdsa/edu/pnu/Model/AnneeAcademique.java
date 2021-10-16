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
import java.util.Date;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)

@Table(name = "AnneeAcademique")
public class AnneeAcademique implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_ANNEEACADEMIQUE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_ANNEEACADEMIQUE_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "CodeAnneeAcademique", nullable = false, length = 255)
    private String codeAnneeAcademiquemestre;
    @Column(name = "Debut", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date debut;
    @Column(name = "Fin", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date fin;

    @OneToMany (mappedBy = "anneeAcademiques", targetEntity = fdsa.edu.pnu.Model.Semestre.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set semestres = new java.util.HashSet();

    @OneToMany(mappedBy = "anneeAcademique", targetEntity = fdsa.edu.pnu.Model.Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiements = new java.util.HashSet();

    public AnneeAcademique(Date debut, Date fin, Set semestres, Set paiements) {
        this.debut = debut;
        this.fin = fin;
        this.semestres = semestres;
        this.paiements = paiements;
    }

    public int getId() {
        return id;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Set getSemestres() {
        return semestres;
    }

    public void setSemestres(Set semestres) {
        this.semestres = semestres;
    }

    public Set getPaiements() {
        return paiements;
    }

    public void setPaiements(Set paiements) {
        this.paiements = paiements;
    }


}
