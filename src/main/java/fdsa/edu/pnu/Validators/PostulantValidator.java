package fdsa.edu.pnu.Validators;

import fdsa.edu.pnu.Model.Postulant;
import fdsa.edu.pnu.ServiceImpl.PostulantService;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostulantValidator {


    private static PostulantService postulantService;

    public static List<String> validate(Postulant postulant) {
        List<String> errors = new ArrayList<>();

        Optional<Postulant> p = postulantService.findById(postulant.getId());

        if (postulant == null) {
            errors.add("Le champ email ne peut pas etre vide");
            return errors;
        }
        if (!StringUtils.hasLength(postulant.getEmail())) {
            errors.add("Le champ email ne peut pas etre vide");
        }

        if (p.isPresent()) {
            errors.add("cet email existe deja dans la base donnees");
        }

        /* 4. Check that the data format is correct for emails */

        if (!postulant.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+"
                + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.add("le format de votre email est invalide");
        }

        return errors;
    }
}
