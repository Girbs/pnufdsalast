package fdsa.edu.pnu;

import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.ServiceImpl.EtudiantService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PnuApplication {


    public static void main(String[] args) {
        SpringApplication.run(PnuApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Etudiant etudiant() {
        return new Etudiant();
    }

    @Bean
    public EtudiantService etudiantService() {
        return new EtudiantService();
    }
}
