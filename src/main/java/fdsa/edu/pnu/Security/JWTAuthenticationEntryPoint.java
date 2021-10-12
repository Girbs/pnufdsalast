package fdsa.edu.pnu.Security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.Security
 * @Date: Sep 20, 2021
 * @Subclass JWTAuthenticationEntryPoint Description:
 */
//Imports

//Begin Subclass JWTAuthenticationEntryPoint
@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest hsr, HttpServletResponse hsr1, AuthenticationException ae) throws IOException, ServletException {
        hsr1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acces Non Autorisé");
    }

} //End Subclass JWTAuthenticationEntryPoint