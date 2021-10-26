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
import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="Personne")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Personnes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personne implements Serializable {
	
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PERSONNE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PERSONNE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Commune.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CommuneID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="CommunePersonne"))	
	private Commune commune;
	
	@Column(name="Nom", nullable=true, length=255)	
	private String nom;
	
	@Column(name="Prenom", nullable=true, length=255)	
	private String prenom;
	
	@Column(name="CinNif", nullable=true, length=255)	
	private String cinNif;
	
	@Column(name="Sexe", nullable=true, length=255)	
	private String sexe;
	
	@Column(name="Telephone1", nullable=true, length=255)	
	private String telephone1;
	
	@Column(name="Telephone2", nullable=true, length=255)	
	private String telephone2;
	
	@Column(name="Adresse", nullable=true, length=255)	
	private String adresse;
	
	@Column(name="CodePostal", nullable=true, length=255)	
	private String codePostal;
	
	
}
