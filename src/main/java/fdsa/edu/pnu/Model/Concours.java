package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity

@Table(name = "Concours")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
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

    @Column(name = "status", nullable = true, length = 255)
    private String status;

    @JsonIgnoreProperties(value = {"concours"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "concours", targetEntity = PlannificationConcours.class)
    private List<PlannificationConcours> plannificationConcourses;

    public Concours() {
    }
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public java.util.Date getDateDebut() {
//		return DateDebut;
//	}
//
//	public void setDateDebut(java.util.Date dateDebut) {
//		DateDebut = dateDebut;
//	}
//
//	public java.util.Date getDateFin() {
//		return DateFin;
//	}
//
//	public void setDateFin(java.util.Date dateFin) {
//		DateFin = dateFin;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public List<PlannificationConcours> getPlannificationConcourses() {
//		if(plannificationConcourses==null){
//			plannificationConcourses= new ArrayList<PlannificationConcours>();
//		}
//		return plannificationConcourses;
//	}
//
//	public void setPlannificationConcourses(List<PlannificationConcours> plannificationConcourses) {
//		this.plannificationConcourses = plannificationConcourses;
//	}
}
