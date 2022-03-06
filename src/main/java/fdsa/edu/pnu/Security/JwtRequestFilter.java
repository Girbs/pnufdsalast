package fdsa.edu.pnu.Security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.Security
 * @Date: Sep 20, 2021
 * @Subclass JwtRequestFilter Description:
 */
//Imports
//Begin Subclass JwtRequestFilter
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest hsr, HttpServletResponse hsr1,
                                    FilterChain fc) throws ServletException, IOException {
        final String header = hsr.getHeader("Authorization");

        String jwToken = null;
        String userName = null;
        if (header != null && header.startsWith("Bearer ")) {
            jwToken = header.substring(7);

            try {
                userName = jwtUtil.getUserNameFromToken(jwToken);

            } catch (IllegalArgumentException e) {
                e.getMessage();
                System.out.print(" infomaryon yo pa korek" + e.getMessage());
            } catch (ExpiredJwtException e) {
                e.getMessage();
                System.out.print(" Token ou a Exprire");
            }
        } else {
            System.out.println("jwtToken does not start with Bearer ");
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = jwtService.loadUserByUsername(userName);
            if (jwtUtil.validatToken(jwToken, userDetails)) {
                UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(hsr));
                SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);

            }
        }
        fc.doFilter(hsr, hsr1);
    }
} //End Subclass JwtRequestFilter
