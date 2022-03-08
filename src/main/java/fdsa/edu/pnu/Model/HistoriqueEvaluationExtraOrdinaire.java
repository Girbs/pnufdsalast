package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


    @Entity
    @Getter
    @Setter
    @JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
    @Table(name = "HistoriqueEvaluationExtraOrdinaire")

    public class HistoriqueEvaluationExtraOrdinaire extends Audit<String> implements Serializable {
        @Column(name = "ID", nullable = false, length = 10)
        @Id
        @GeneratedValue(generator = "PNU_EVALUATION_ID_GENERATOR")
        @org.hibernate.annotations.GenericGenerator(name = "PNU_EVALUATION_ID_GENERATOR", strategy = "native")
        private int id;


    @JsonIgnoreProperties(value = {"historiqueEvaluationExtraOrdinaireList"}, allowSetters = true)
    @ManyToOne(targetEntity = EvaluationExtraordinaire.class, fetch = FetchType.LAZY)
    @JoinColumns(value = {@JoinColumn(name = "evaluation_extraordinaire_id", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "HistoriqueevaluationExtraordinaires"))
    private EvaluationExtraordinaire evaluationExtraordinaire;

    @ManyToOne(targetEntity = CoursEtudiant.class, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"historiqueEvaluationExtraOrdinaireList"}, allowSetters = true)
    @JoinColumns(value = {@JoinColumn(name = "cours_etudiant_id", referencedColumnName = "ID", nullable = true)}, foreignKey = @ForeignKey(name = "HistoriqueevaluationExtraordinairesCoursEtudiant"))
    private CoursEtudiant coursEtudiant;
}
