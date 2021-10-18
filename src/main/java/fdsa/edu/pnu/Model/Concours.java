/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "concours", targetEntity = fdsa.edu.pnu.Model.PlannificationConcours.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<PlannificationConcours> plannificationConcourses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        DateDebut = dateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date dateFin) {
        DateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PlannificationConcours> getPlannificationConcourses() {
        return plannificationConcourses;
    }

    public void setPlannificationConcourses(List<PlannificationConcours> plannificationConcourses) {
        this.plannificationConcourses = plannificationConcourses;
    }



    public Concours() {
    }




}
