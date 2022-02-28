package fdsa.edu.pnu.Security;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.config
 * @Date: Sep 18, 2021
 * @Subclass SecurityConfiguration Description:
 */
//Imports

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//Begin Subclass SecurityConfiguration
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public JwtRequestFilter jwtRequestFilter;
    @Autowired
    private UserDetailsService jwtService;
    @Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();

        http.csrf().disable()
                .authorizeRequests().antMatchers(


                        "/authenticate",
                        "/postulant/nouveau",
                        "/matiere/listeDynamique",
                        "/resultatExamenConcours/{id}",
                        "/postulant/all",
                        "/sessionProgramme/all",
                        "/plannificationConcoursByIdConcours/{id}",
                        "/programme/all",
                        "/programme/nouveau",
                        "/postulant/{statut}",
                        "/resultatExamenConcoursPageable",
                        "/historiqueExamenConcours/all",
                        "/modifierPostulant/{id}",
                        "/plannificationConcours/all",
                        "/plannificationConcours/nouveau",
                        "/plannificationConcours/supprimer/{id}",
                        "/plannificationConcours/{id}",
                        "/plannificationConcours/listeDynamique",
                        "/anneeAcademique/all",
                        "/utilisateur/motDePasseOublie",
                        "/role/all",
                        "/matiere/all/customQuery",
                        "/concours/findAllCustomQuery",
                        "/concours/all",
                        "/permission/all",
                        "/utilisateur/all",
                        "/utilisateur/{id}",
                        "/postulant/all/{offset}/{pageSize}/{field}",
                        "/postulant/all/{offset}/{pageSize}/{field}/{filter}",
                        "/postulantPageWithFilter/{offset}/{pageSize}/{field}/{prenom}",
                        "/professeur/nouveau",
                        "/personnel/all",
                        "/personnel/nouveau",
                        "/personnel/{id}",
                        "/matiere/all",
                        "/matiere/nouveau",
                        "/matiere/supprimer/{id}",
                        "/matiere/{id}",
                        "concours/all",
                        "/concours/{id}",
                        "/concours/nouveau",
                        "/concours/listeDynamique",
                        "/concours/supprimer/{id}",
                        "/postulantPageWithFilter",


                        "/saveStudent",
                        "/getStudent",
                        "/modifierConcours/{id}",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**").permitAll()
                .antMatchers(HttpHeaders.ALLOW).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtService).passwordEncoder(passwordEncoder());

    }
}
