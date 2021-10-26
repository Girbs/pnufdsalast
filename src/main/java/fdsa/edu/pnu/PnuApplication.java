package fdsa.edu.pnu;

import fdsa.edu.pnu.Config.SpringSecurityAuditorAware;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.ServiceImpl.EtudiantService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
public class PnuApplication {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
	public static void main(String[] args) {
		SpringApplication.run(PnuApplication.class, args);
	}

    @Bean
    public Etudiant etudiant(){
        return new Etudiant();
    }
    
     @Bean
    public EtudiantService etudiantService(){
        return new EtudiantService();
    }
}
