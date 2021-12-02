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

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@JsonIdentityReference(alwaysAsId = true)
@Table(name="Concours")
public class Concours  {

	@Column(name="ID", nullable=false, length=10)
	@Id
	@GeneratedValue(generator="PNU_CONCOURS_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="PNU_CONCOURS_ID_GENERATOR", strategy="native")

	private Integer id;

	@Column(name="DateDebut", nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date DateDebut;

	@Column(name="DateFin", nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date DateFin;

	@Column(name="Description", nullable=true, length=255)
	private String description;

	@OneToMany(mappedBy = "concours", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // mappedBy will create a bidirectional relation for us
	private List<PlannificationConcours> plannificationConcourses;

	public Concours() {
	}

}
