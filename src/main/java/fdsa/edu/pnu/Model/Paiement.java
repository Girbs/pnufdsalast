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

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "Paiement")
public class Paiement implements Serializable {
    @OneToMany(mappedBy = "paiement", targetEntity = Requete.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private final java.util.Set requetes = new java.util.HashSet();
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_PAIEMENT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_PAIEMENT_ID_GENERATOR", strategy = "native")
    private int id;

    @Column(name = "NumeroPaiement", nullable = true, length = 255)
    private String numeroPaiement;

    @Column(name = "Montant", nullable = true, precision = 19, scale = 0)
    private java.math.BigDecimal montant;

    @Column(name = "DatePaiement", nullable = true)
    private java.sql.Timestamp datePaiement;

    @Column(name = "Remarque", nullable = true, length = 255)
    private String remarque;

    @ManyToOne(targetEntity = Semestre.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "SemestreID", referencedColumnName = "ID")}, foreignKey = @ForeignKey(name = "PaimentSemestre"))
    private Semestre semestre;

    @ManyToOne(targetEntity = Etudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_PAIEMENTS_ETUDIANTS"))
    private Etudiant etudiant;

    @ManyToOne(targetEntity = TypePaiement.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "TypePaiementID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_PAIEMENTS_TYPES_PAIEMENT"))
    private TypePaiement typePaiement;

    public Paiement() {
    }

}
