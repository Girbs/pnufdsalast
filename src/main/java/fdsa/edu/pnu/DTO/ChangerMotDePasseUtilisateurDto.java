package fdsa.edu.pnu.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseUtilisateurDto {

    private String userName;

    private String motDePasse;

    private String confirmMotDePasse;

}