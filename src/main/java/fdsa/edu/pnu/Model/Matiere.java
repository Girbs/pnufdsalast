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
@Table(name = "Matiere")
public class Matiere implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_MATIERE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_MATIERE_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "Description", nullable = true, length = 255)
    private String description;

//	@ManyToOne(targetEntity=fdsa.edu.PNUFDSA.Model.Matiere.class, fetch=FetchType.LAZY)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
//	@JoinColumns(value={ @JoinColumn(name="MatiereID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="Pre-requis"))	
//	private fdsa.edu.PNUFDSA.Model.Matiere matiere;
    @Column(name = "Code", nullable = true, length = 255)
    private String code;
    @Column(name = "Contenu", nullable = true, length = 255)
    private String Contenu;
    @Column(name = "NombreDeCreditStandard", nullable = false, length = 10)
    private int nombreDeCreditStandard;
    @OneToMany(mappedBy = "matiere", targetEntity = fdsa.edu.pnu.Model.Cours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set cours = new java.util.HashSet();
    @OneToMany(mappedBy = "matiere", targetEntity = fdsa.edu.pnu.Model.PlannificationConcours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set plannificationConcourses = new java.util.HashSet();

    public Matiere() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String value) {
        this.Contenu = value;
    }

    public int getNombreDeCreditStandard() {
        return nombreDeCreditStandard;
    }

    public void setNombreDeCreditStandard(int value) {
        this.nombreDeCreditStandard = value;
    }

//	public void setMatiere(fdsa.edu.PNUFDSA.Model.Matiere value) {
//		this.matiere = value;
//	}
//	
//	public fdsa.edu.PNUFDSA.Model.Matiere getMatiere() {
//		return matiere;
//	}

    public java.util.Set getCours() {
        return cours;
    }

    public void setCours(java.util.Set value) {
        this.cours = value;
    }

    public java.util.Set getPlannificationConcourses() {
        return plannificationConcourses;
    }

    public void setPlannificationConcourses(java.util.Set value) {
        this.plannificationConcourses = value;
    }

//	
//	public void setMatieres(java.util.Set value) {
//		this.matieres = value;
//	}
//	
//	public java.util.Set getMatieres() {
//		return matieres;
//	}
//	

    public String toString() {
        return String.valueOf(getId());
    }

}
