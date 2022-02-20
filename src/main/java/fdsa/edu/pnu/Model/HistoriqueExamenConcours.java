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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="HistoriqueExamenConcours")
public class HistoriqueExamenConcours implements Serializable {

	@Column(name="ID", nullable=false, length=10)
	@Id
	@GeneratedValue(generator="PNU_HISTORIQUEEXAMENCONCOURS_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="PNU_HISTORIQUEEXAMENCONCOURS_ID_GENERATOR", strategy="native")
	private int ID;

	@Column(name="NoteObtenue", nullable=false, length=10)
	private double noteObtenue;

	@ManyToOne(targetEntity= PlannificationConcours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="PlannificationConcoursID", referencedColumnName="ID") })
	public PlannificationConcours plannificationConcours;

	@ManyToOne(targetEntity= Postulant.class)
	@JsonBackReference
	@JoinColumns({ @JoinColumn(name="PostulantID", referencedColumnName="ID") })
	private Postulant postulant;

}
