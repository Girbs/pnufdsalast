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

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Data
@AllArgsConstructor

@Table(name="PlannificationConcours")
public class PlannificationConcours implements Serializable {
	public PlannificationConcours() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_PLANNIFICATIONCONCOURS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_PLANNIFICATIONCONCOURS_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne
	private Concours concours;
	
//	@ManyToOne(targetEntity= Matiere.class, fetch=FetchType.LAZY)
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
//	@JoinColumns(value={ @JoinColumn(name="MatiereID", referencedColumnName="ID", nullable=true) }, foreignKey=@ForeignKey(name="Concerner"))
//	private Matiere matiere;
	
	@Column(name="`Date`", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date Date;
	
	@Column(name="Quotation", nullable=false, length=10)	
	private double quotation;
	
	@Column(name="NoteDePassage", nullable=false, length=10)	
	private double noteDePassage;
	
	@OneToMany(mappedBy="plannificationConcours", targetEntity= HistoriqueExamenConcours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Collection<HistoriqueExamenConcours> historiqueExamenConcours;
	
	
}
