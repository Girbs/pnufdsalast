package fdsa.edu.pnu.Config;

import fdsa.edu.pnu.Security.JWTService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    private String currentUser = "gbijou";
    private JWTService jwtService;

    public void setCurrentUser(String user) {
        currentUser = user;
    }

    @Override
    public Optional<String> getCurrentAuditor() {

        // Just return a string representing the username
        return Optional.ofNullable(currentUser).filter(s -> !s.isEmpty());
    }

}