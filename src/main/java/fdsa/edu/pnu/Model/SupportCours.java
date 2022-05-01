package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "SupportCours")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class SupportCours implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_SUPPORT_COURS_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_SUPPORT_COURS_ID_GENERATOR", strategy = "native")
    private int ID;

    @JsonIgnoreProperties(value = {"supportCours"}, allowSetters = true)
    @ManyToOne(targetEntity = Cours.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "CoursID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "SupportCours"))
    private Cours cours;

    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Column(name = "lienRessource", nullable = true, length = 255)
    private String lienRessource;

    public SupportCours() {
    }


}
