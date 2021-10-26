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
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor

@Table(name="Concours")
public class Concours implements Serializable {
	public Concours() {
	}

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
	
	@OneToMany(mappedBy="concours", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity= PlannificationConcours.class)
	private List<PlannificationConcours> plannificationConcourses = new ArrayList<>();

	public void addPlannificationConcours(PlannificationConcours child) {
		child.setConcours(this); // and don't forget to set the parent instance to the child
		this.plannificationConcourses.add(child);
	}


}
