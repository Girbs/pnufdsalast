package fdsa.edu.pnu.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
public class ResultatConcours {

    private String postulant;
    private String matricule;
    private double moyenne;

    public ResultatConcours(String postulant, String matricule, double moyenne) {
        this.postulant = postulant;
        this.matricule = matricule;
        this.moyenne = moyenne;
    }

}
