package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "Donation")
public class Donation extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_Donation")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_Donation_ID_GENERATOR", strategy = "native")
    private int id;

    @Column(name = "Description", nullable = true, length = 255)
    private String description;

    @Column(name = "dateDePromesse", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date dateDePromesse;

    @Column(name = "dateeffectiveAnticipee", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date dateeffectiveAnticipee;

    @Column(name = "dateeffective", nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date dateeffective;


    @Column(name = "descriptionDetaille", nullable = true, length = 255)
    private String descriptionDetaille;

    @Column(name = "statut", nullable = true, length = 255)
    private String statut;

    @JsonIgnoreProperties(value = {"donations"}, allowSetters = true)
    @ManyToOne(targetEntity = Entreprise.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "EntrepriseId", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "FK_Entreprise_Donation"))
    private Entreprise entreprise;

}
