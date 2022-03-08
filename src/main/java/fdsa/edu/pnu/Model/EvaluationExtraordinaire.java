package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "EvaluationExtraOrdinaire")
public class EvaluationExtraordinaire extends Audit<String> implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_EVALUATION_EXTRAORDINAIRE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_EVALUATION_EXTRAORDINAIRE_ID_GENERATOR", strategy = "native")
    private int id;

    private String description;
    private Date date;

    @JsonIgnoreProperties(value = {"evaluationExtraordinaires"}, allowSetters = true)
    @ManyToOne(targetEntity = Examen.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "examen_id", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "evaluationExtraordinairesExamen"))
    private Examen examen;

    @JsonIgnoreProperties(value = {"evaluationExtraordinaireList"}, allowSetters = true)
    @ManyToOne(targetEntity = CoursProgramme.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "coursProgramme_id", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "evaluationExtraordinairesCoursProgramme"))
    private CoursProgramme coursProgramme;

    @JsonIgnoreProperties(value = {"evaluationExtraordinaire"}, allowSetters = true)
    @OneToMany(mappedBy = "evaluationExtraordinaire", targetEntity = HistoriqueEvaluationExtraOrdinaire.class)
    private List<HistoriqueEvaluationExtraOrdinaire> historiqueEvaluationExtraOrdinaireList;
}
