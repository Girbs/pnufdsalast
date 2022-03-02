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
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Table(name = "Institution")
public class Institution implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_INSTITUTION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_INSTITUTION_ID_GENERATOR", strategy = "native")
    private int id;
    @Column(name = "NomInstitution", nullable = true, length = 255)
    private String nomInstitution;
    @Column(name = "Adresse", nullable = true, length = 255)
    private String adresse;
    @Column(name = "Telephone", nullable = true, length = 255)
    private String telephone;
    @Column(name = "personneDeContact", nullable = true, length = 255)
    private String personneDeContact;

    @JsonIgnoreProperties(value = {"institution"}, allowSetters = true)
    @OneToMany(mappedBy = "institution", targetEntity = Stage.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private List<Stage> stages;

    public Institution() {
    }


}
