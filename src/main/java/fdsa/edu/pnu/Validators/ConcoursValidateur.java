package fdsa.edu.pnu.Validators;

import fdsa.edu.pnu.Model.Concours;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcoursValidateur {

    public static List<String> validate(Concours concours) {
        List<String> errors = new ArrayList<>();

        if (concours == null) {
            errors.add("Veuillez renseigner la description");
            errors.add("Veuillez renseigner la date du debut");
            return errors;
        }

        if (!StringUtils.hasLength(concours.getDescription())) {
            errors.add("Veuillez renseigner la description du concours");
        }
        if (concours.getDateDebut() == null) {
            errors.add("Veuillez renseigner la date de debut du concours");
        }
        if (concours.getDateDebut().after(concours.getDateFin())) {
            errors.add("La date du debut ne peut pas etre superieur à la date de la fin ");
        }


        return errors;
    }
}
