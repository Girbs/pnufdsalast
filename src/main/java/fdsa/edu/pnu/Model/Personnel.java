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
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="Personnel")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Personnel")
public class Personnel extends Utilisateur implements Serializable {
	public Personnel() {
	}
	
	@ManyToOne(targetEntity= Fonction.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="FonctionID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="FKPersonnel768785"))	
	private Fonction fonctionpersonel;
	
	public void setFonctionpersonel(Fonction value) {
		this.fonctionpersonel = value;
	}
	
	public Fonction getFonctionpersonel() {
		return fonctionpersonel;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
