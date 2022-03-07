package fdsa.edu.pnu.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "Examen")
public class Examen extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EXAMEN_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EXAMEN_ID_GENERATOR", strategy = "native")

    private Integer id;
    private String description;
    private Date dateDebut;
    private Date dateFin;

     @JsonIgnoreProperties(value = {"examens"}, allowSetters = true)
     @ManyToOne(targetEntity = Examen.class, fetch = FetchType.LAZY)
     @JoinColumns(value = {@JoinColumn(name = "session_id", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "SessionExamen"))
     private Session session;


}
