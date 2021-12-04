
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
@Table(name = "Concours")
public class Concours implements Serializable {
	@Column(name = "ID", nullable = false, length = 10)
	@Id
	@GeneratedValue(generator = "PNU_CONCOURS_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "PNU_CONCOURS_ID_GENERATOR", strategy = "native")
	private Integer id;
	@Column(name = "DateDebut", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date DateDebut;
	@Column(name = "DateFin", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date DateFin;
	@Column(name = "Description", nullable = true, length = 255)
	private String description;
	@OneToMany( fetch =FetchType.EAGER, mappedBy=  "concours", targetEntity = fdsa.edu.pnu.Model.PlannificationConcours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set plannificationConcourses = new java.util.HashSet();

	public Concours() {
	}

	public Integer getId() {
		return id;
	}

	private void setId(int value) {
		setId(new Integer(value));
	}

	private void setId(Integer value) {
		this.id = value;
	}

	public Integer getORMID() {
		return getId();
	}

	public java.util.Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(java.util.Date value) {
		this.DateDebut = value;
	}

	public java.util.Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(java.util.Date value) {
		this.DateFin = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public java.util.Set getPlannificationConcourses() {
		return plannificationConcourses;
	}

	public void setPlannificationConcourses(java.util.Set value) {
		this.plannificationConcourses = value;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
