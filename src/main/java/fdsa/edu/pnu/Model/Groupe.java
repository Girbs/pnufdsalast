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
@Table(name = "Groupe")
public class Groupe implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_GROUPE_IDGROUPE_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_GROUPE_IDGROUPE_GENERATOR", strategy = "native")
    private int idGroupe;
    @Column(name = "Nom", nullable = true, length = 255)
    private String nom;

//	@ManyToMany(targetEntity=fdsa.edu.pnu.Model.Utilisateur.class)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinTable(name="Utlilisateur_Groupe", joinColumns={ @JoinColumn(name="GroupeID") }, inverseJoinColumns={ @JoinColumn(name="UtlilisateurPersonneID") })	
//	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
//	private java.util.Set utlilisateurs = new java.util.HashSet();
    @Column(name = "Photo", nullable = true, length = 255)
    private String photo;
    @ManyToMany(mappedBy = "groupe", targetEntity = Discussion.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set discussion = new java.util.HashSet();

//	@ManyToOne(targetEntity=fdsa.edu.pnu.Model.Utilisateur.class, fetch=FetchType.LAZY)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinColumns(value={ @JoinColumn(name="UtlilisateurPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="Creer"))	
//	private fdsa.edu.pnu.Model.Utilisateur utlilisateur;

    public Groupe() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String value) {
        this.photo = value;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    private void setIdGroupe(int value) {
        this.idGroupe = value;
    }

    public int getORMID() {
        return getIdGroupe();
    }
//	
//	public void setUtlilisateurs(java.util.Set value) {
//		this.utlilisateurs = value;
//	}
//	
//	public java.util.Set getUtlilisateurs() {
//		return utlilisateurs;
//	}
//	
//	
//	public void setUtlilisateur(fdsa.edu.pnu.Model.Utilisateur value) {
//		this.utlilisateur = value;
//	}
//	
//	public fdsa.edu.pnu.Model.Utilisateur getUtlilisateur() {
//		return utlilisateur;
//	}

    public java.util.Set getDiscussion() {
        return discussion;
    }

    public void setDiscussion(java.util.Set value) {
        this.discussion = value;
    }

    public String toString() {
        return String.valueOf(getIdGroupe());
    }

}
