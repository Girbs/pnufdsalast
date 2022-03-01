package fdsa.edu.pnu.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
public class ResultatConcours {
    private Integer idpostulant;
    private String postulant;
    private String matricule;
    private double moyenne;

    public ResultatConcours(Integer idpostulant, String postulant, String matricule, double moyenne) {
        this.idpostulant = idpostulant;
        this.postulant = postulant;
        this.matricule = matricule;
        this.moyenne = moyenne;
    }

}
