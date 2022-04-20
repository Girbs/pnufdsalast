package fdsa.edu.pnu.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgrammeDTO {
    private int id;
    private String sigle;
    private String description;
}
