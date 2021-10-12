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
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Session`")
public class Session implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_SESSION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_SESSION_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Programme.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "ProgrammeID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_SESSIONS_PROGRAMMES"))
    private fdsa.edu.pnu.Model.Programme programme;
    @Column(name = "DescriptionSession", nullable = true, length = 255)
    private String descriptionSession;
    @Column(name = "CodeSession", nullable = true, length = 255)
    private String codeSession;
    @Column(name = "Ordre", nullable = false, length = 10)
    private int ordre;
    @OneToMany(mappedBy = "session", targetEntity = fdsa.edu.pnu.Model.PaiementSession.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiementSessions = new java.util.HashSet();

//	@ManyToMany(targetEntity=fdsa.edu.pnu.Model.Cours.class)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinTable(name="Cours_Session", joinColumns={ @JoinColumn(name="SessionID") }, inverseJoinColumns={ @JoinColumn(name="CoursID") })	
//	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
//	private java.util.Set cours = new java.util.HashSet();
    @OneToMany(mappedBy = "session", targetEntity = fdsa.edu.pnu.Model.Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set cours = new java.util.HashSet();
    @OneToMany(mappedBy = "session", targetEntity = fdsa.edu.pnu.Model.Paiement.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set paiements = new java.util.HashSet();

    public Session() {
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

    public String getDescriptionSession() {
        return descriptionSession;
    }

    public void setDescriptionSession(String value) {
        this.descriptionSession = value;
    }

    public String getCodeSession() {
        return codeSession;
    }

    public void setCodeSession(String value) {
        this.codeSession = value;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int value) {
        this.ordre = value;
    }

    public fdsa.edu.pnu.Model.Programme getProgramme() {
        return programme;
    }

    public void setProgramme(fdsa.edu.pnu.Model.Programme value) {
        this.programme = value;
    }

    public java.util.Set getCours() {
        return cours;
    }

    public void setCours(java.util.Set value) {
        this.cours = value;
    }

    public java.util.Set getPaiementSessions() {
        return paiementSessions;
    }

    public void setPaiementSessions(java.util.Set value) {
        this.paiementSessions = value;
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
