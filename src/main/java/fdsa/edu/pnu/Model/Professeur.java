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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Professeur")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Professeur extends Utilisateur implements Serializable {


    @Column(name = "CodeProfesseur", nullable = true, length = 255)
    private String codeProfesseur;

    @Column(name = "Titre", nullable = true, length = 255)
    private String titre;

    @Column(name = "LienCv", nullable = true, length = 255)
    private String lienCv;

    @JsonIgnoreProperties(value = {"professeur"}, allowSetters = true)
    @OneToMany(mappedBy = "professeur", targetEntity = Cours.class, fetch = FetchType.LAZY)
    private List<Cours> cours;



    //	@OneToMany(mappedBy="professeur", targetEntity= Cours.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//	private List<Cours> cours;
//
    @OneToMany(mappedBy = "professeur", targetEntity = Publication.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Publication> publications;


}
