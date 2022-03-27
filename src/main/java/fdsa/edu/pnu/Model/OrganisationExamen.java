package fdsa.edu.pnu.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "evaluationOrdinaires"})
@Table(name = "OrganisationExamen")
public class OrganisationExamen extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EXAMEN_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EXAMEN_ID_GENERATOR", strategy = "native")

    private Integer id;
    private String description;
    private Date dateDebut;
    private Date dateFin;


    @JsonIgnoreProperties(value = {"organisationExamen"}, allowSetters = true)
    @OneToMany(mappedBy = "organisationExamen", targetEntity = Evaluation.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Evaluation> evaluation;


}
