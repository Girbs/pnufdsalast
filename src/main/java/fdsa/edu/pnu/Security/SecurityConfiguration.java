package fdsa.edu.pnu.Security;


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
                        "/coursEtudiant/nouveau",
                        "/ListeCoursSessionEtudiantByProgramme/{idEtudiant}/{idProgramme}",
                        "/getEvaluationsByOrganisationExamenId/{idOrganisationExamen}",
                        "/organisationExamen/all",
                        "/matiere/listeDynamique",
                        "/findHistoriqueEvaluationByIdEvaluation/{IdEvaluation}",
                        "/findHistoriqueEvaluationByIdCoursEtudiant/{IdCoursEtudiant}",
                        "/resultatExamenConcours/{id}",
                        "/postulant/all",
                        "/etudiant/all",
                        "/evaluation/nouveau",
                        "/horaire/all",
                        "/historiqueEvaluation/all",
                "/historiqueEvaluation/nouveau",
                        "/ListeCoursEtudiant/all",
                        "/coursEtudiant/all",
                        "/evaluation/all",
                        "/sessionProgramme/all",
                        "/plannificationConcoursByIdConcours/{id}",
                        "/programme/all",
                        "/etudiant/listeDynamique",
                        "/coursEtudiant/enregistrerListe",
                        "/programme/{id}",
                        "/programme/ListProgrammeByIdEtudiant/{idEtudiant}",
                        "/username",
                        "/programme/nouveau",
                        "/session/all",
                "/session/{id}",
                        "/coursProgramme/findListCoursAndPrerequisByIdProgram/{idProgramme}",
                        "/nombreDeCoursCompletesByEtudiantByProgramme/{idEtudiant}/{idProgramme}",
                        "/nombreDeCoursAReprendreByEtudiantByProgramme/{idEtudiant}/{idProgramme}",
                        "/coursProgramme/findNombreDeCoursByProgramme/{IdProgramme}",
                        "/coursEtudiantByIdEtudiantByProgramme/{idEtudiant}/{idProgramme}",
                        "/coursProgramme/all",
                        "/cours/ListeCoursDiponiblesPourEdudiant/{idEtudiant}/{idProgramme}",
                        "/coursProgramme/{id}",
                        "/postulant/{statut}",
                        "/file/upload",
                        "/file/download/{fileName}",
                        "/resultatExamenConcoursPageable",
                        "/historiqueExamenConcours/all",
                        "/evaluationByIdCours/{idCours}",
                        "/modifierPostulant/{id}",
                        "/findListCoursAndPrerequisByIdProgram/{idProgramme}",
                        "/plannificationConcours/all",
                        "/plannificationConcours/nouveau",
                        "/plannificationConcours/supprimer/{id}",
                        "/plannificationConcours/{id}",
                        "/plannificationConcours/listeDynamique",
                        "/anneeAcademique/all",
                        "/utilisateur/motDePasseOublie",
                        "/donation/all",
                        "/historiqueEvaluation/soumettreDevoir",
                        "/donation/{id}",
                        "/donation/nouveau",
                        "/entreprise/all",
                        "/entreprise/{id}",
                        "/entreprise/nouveau",
                        "/stage/all",
                        "/stage/{id}",
                        "/stage/nouveau",
                        "/role/all",
                        "/role/nouveau",
                        "/role/{id}",
                        "/upload",
                        "/",
                        "/matiere/all/customQuery",
                        "/concours/findAllCustomQuery",
                        "/historiqueExamenConcours/nouveau",
                        "/historiqueExamenConcoursByPlanificationConcours/{id}",
                        "/concours/all",
                        "/permission/all",
                        "/permission/{id}",
                        "/utilisateur/all",
                        "/utilisateur/{id}",
                        "/postulant/all/{offset}/{pageSize}/{field}",
                        "/postulant/all/{offset}/{pageSize}/{field}/{filter}",
                        "/postulantPageWithFilter/{offset}/{pageSize}/{field}/{prenom}",
                        "/professeur/nouveau",
                        "/professeur/all",
                        "/professeur/{id}",
                        "/personnel/all",
                        "/personnel/{id}",
                        "/personnel/nouveau",
                        "/personnel/supprimer/{id}",
                        "/matiere/all",
                        "/matiere/nouveau",
                        "/cours/all",
                        "/matiere/supprimer/{id}",
                        "/historiqueExamen/nouveau",
                        "/matiere/{id}",
                        "concours/all",
                        "/historiqueExamenEtudiant/{idEtudiant}",
                        "/concours/{id}",
                        "/concours/nouveau",
                        "/concours/listeDynamique",
                        "/concours/supprimer/{id}",
                        "/postulantPageWithFilter",
                        "/saveStudent",
                        "/getStudent",
                        "/api/v1/sms",
                "/coursEtudiantByIdEtudiant/{idEtudiant}",
                        "/historiqueExamen/all",
                        "/sessionProgramme/{id}",
                "/sessionProgramme/all",
                        "/sessionProgrammeByIdProgramme/{idProgramme}",
                        "/coursProgramme/findBySessionId/{idSession}",
                        "/coursProgramme/findNombreDeCreditCompletedByEtudiantByProgramme/{IdProgramme}/{idEtudiant}",
                        "/modifierConcours/{id}",
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/sessionProgramme/nouveau",
                        "/coursProgramme/findNombredeCreditsByProgramme/{IdProgramme}",
                        "/swagger-ui.html",
                        "/coursProgramme/findListCoursProgrammeByEtudiant/{IdProgramme}/{idEtudiant}",
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
