/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

@Table(name="Professeur")
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorValue("Professeurs")
public class Professeur extends Utilisateur implements Serializable {

	
	@Column(name="CodeProfesseur", nullable=true, length=255)	
	private String codeProfesseur;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	@Column(name="LienCv", nullable=true, length=255)	
	private String lienCv;
	
//	@OneToMany(mappedBy="professeur", targetEntity= Cours.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//	private List<Cours> cours;
//
	@OneToMany(mappedBy="professeur", targetEntity= Publication.class,  fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private List<Publication> publications;

	
}
