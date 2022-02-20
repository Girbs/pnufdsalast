
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "id")
//
////@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Long.class)
//
//@JsonIdentityReference(alwaysAsId = true)
@Table(name = "Concours")
public class Concours extends Audit<String> implements Serializable {
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
	@Column(name = "Code", nullable = true, length = 255)
	private String code;

	@Column(name = "status", nullable = true, length = 255)
	private String status;

	//@JsonIgnoreProperties(value = {"concours"}, allowSetters = true)
	@OneToMany( fetch =FetchType.LAZY, mappedBy=  "concours", targetEntity = fdsa.edu.pnu.Model.PlannificationConcours.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private List<PlannificationConcours> plannificationConcourses  ;

	public Concours() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(java.util.Date dateDebut) {
		DateDebut = dateDebut;
	}

	public java.util.Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(java.util.Date dateFin) {
		DateFin = dateFin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PlannificationConcours> getPlannificationConcourses() {
		if(plannificationConcourses==null){
			plannificationConcourses= new ArrayList<PlannificationConcours>();
		}
		return plannificationConcourses;
	}

	public void setPlannificationConcourses(List<PlannificationConcours> plannificationConcourses) {
		this.plannificationConcourses = plannificationConcourses;
	}
}
