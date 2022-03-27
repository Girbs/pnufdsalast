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
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "Stage")
public class Stage implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_STAGE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_STAGE_ID_GENERATOR", strategy = "native")
    private int id;

    @JsonIgnoreProperties(value = {"stages"}, allowSetters = true)
    @ManyToOne(targetEntity = Etudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "EtudiantStage"))
    private Etudiant etudiant;

    @JsonIgnoreProperties(value = {"stages"}, allowSetters = true)
    @ManyToOne(targetEntity = Entreprise.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "InstitutionID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "EntrepriseStage"))
    private Entreprise entreprise;

    @Column(name = "DateDebut", nullable = true)
    private java.sql.Timestamp dateDebut;
    @Column(name = "DateFin", nullable = true)
    private java.sql.Timestamp dateFin;
    @Column(name = "Titre", nullable = true, length = 255)
    private String titre;
    @Column(name = "Commentaire", nullable = true, length = 255)
    private String commentaire;

    public Stage() {
    }

}
