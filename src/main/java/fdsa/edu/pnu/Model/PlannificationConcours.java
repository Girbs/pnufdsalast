/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: EvaluationOrdinaire
 */

/**
 * Licensee: 
 * License Type: EvaluationOrdinaire
 */
package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "PlannificationConcours")
public class PlannificationConcours extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PLANNIFICATIONCONCOURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PLANNIFICATIONCONCOURS_ID_GENERATOR", strategy = "native")
    private int id;
    @JsonIgnoreProperties(value = {"plannificationConcourses"}, allowSetters = true)
    @ManyToOne(targetEntity = Concours.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "concoursId", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "ConcoursPlanificationConcours"))
    private Concours concours;
    //@JsonBackReference
    @JsonIgnoreProperties(value = {"plannificationConcourses"}, allowSetters = true)
    @ManyToOne(targetEntity = Matiere.class, fetch = FetchType.LAZY)
    //@JoinColumns(value={ @JoinColumn(name="MatiereId", referencedColumnName="ID", nullable=true) }, foreignKey=@ForeignKey(name="MatierePlanificationConcours"))
    private Matiere matiere;
    @Column(name = "`Date`", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date Date;
    @Column(name = "Quotation", nullable = false, length = 10)
    private double quotation;
    @Column(name = "Coefficient", nullable = true, length = 10)
    private double coefficient;
    @Column(name = "NoteDePassage", nullable = false, length = 10)
    private double noteDePassage;
    @JsonIgnoreProperties(value = {"plannificationConcours"}, allowSetters = true)
    @OneToMany(mappedBy = "plannificationConcours", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = HistoriqueExamenConcours.class)
    private List<HistoriqueExamenConcours> historiqueExamenConcours;

    public PlannificationConcours() {
    }

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Concours getConcours() {
//		return concours;
//	}
//
//	public void setConcours(Concours concours) {
//		this.concours = concours;
//	}
//
//	public Matiere getMatiere() {
//		return matiere;
//	}
//
//	public void setMatiere(Matiere matiere) {
//		this.matiere = matiere;
//	}
//
//	public java.util.Date getDate() {
//		return Date;
//	}
//
//	public void setDate(java.util.Date date) {
//		Date = date;
//	}
//
//	public double getQuotation() {
//		return quotation;
//	}
//
//	public void setQuotation(double quotation) {
//		this.quotation = quotation;
//	}
//
//	public double getNoteDePassage() {
//		return noteDePassage;
//	}
//
//	public void setNoteDePassage(double noteDePassage) {
//		this.noteDePassage = noteDePassage;
//	}
//
//	public List<HistoriqueExamenConcours> getHistoriqueExamenConcours() {
//		return historiqueExamenConcours;
//	}
//
//	public void setHistoriqueExamenConcours(List<HistoriqueExamenConcours> historiqueExamenConcours) {
//		this.historiqueExamenConcours = historiqueExamenConcours;
//	}
}
