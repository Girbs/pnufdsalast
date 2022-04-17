package fdsa.edu.pnu.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Setter
@Getter
@Table(name = "ProgrammeEtudiant")
//@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class ProgrammeEtudiant implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "ProgrammeEtudiant_ID_GENERATOR")
    private int id;
    private Date dateDebut;

    @ManyToOne
    @JsonIgnoreProperties(value = {"programmesEtudiant"}, allowSetters = true)
    private Etudiant etudiant;

  @ManyToOne
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @JsonIgnoreProperties(value = {"programmesEtudiant"}, allowSetters = true)
  private Programme programme;
  private  int programmedetudeId;



}
