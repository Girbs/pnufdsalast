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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Matiere")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Matiere extends Audit<String> implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_MATIERE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_MATIERE_ID_GENERATOR", strategy = "native")
    private int id;

//	@ManyToOne(targetEntity=fdsa.edu.PNUFDSA.Model.Matiere.class, fetch=FetchType.LAZY)
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
//	@JoinColumns(value={ @JoinColumn(name="MatiereID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="Pre-requis"))
//	private fdsa.edu.PNUFDSA.Model.Matiere matiere;

    @Column(name = "Description", nullable = true, length = 255)
    private String description;

    @Column(name = "Code", nullable = true, length = 255)
    private String code;

    @Column(name = "Contenu", nullable = true, length = 255)
    private String Contenu;

    @Column(name = "NombreDeCreditStandard", nullable = false, length = 10)
    private int nombreDeCreditStandard;

    @JsonIgnoreProperties(value = {"matiere"}, allowSetters = true)
    @OneToMany(mappedBy = "matiere", targetEntity = CoursProgramme.class)
    private List<CoursProgramme> coursProgrammes;

    @JsonIgnoreProperties(value = {"matiere"}, allowSetters = true)
    @OneToMany(mappedBy = "matiere", targetEntity = PlannificationConcours.class)
    private List<PlannificationConcours> plannificationConcourses;

    public Matiere() {
    }


}
