package fdsa.edu.pnu.Security;

import fdsa.edu.pnu.Config.SpringSecurityAuditorAware;
import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Model.Utilisateur;
import fdsa.edu.pnu.Repository.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class JWTService implements UserDetailsService {

    @Autowired
    private UtilisateurDAO userDAO;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SpringSecurityAuditorAware springSecurityAuditorAware;


    public static Date getLastLoginDate() {
        Date timestamp = new Date(System.currentTimeMillis());
        return timestamp;
    }


    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {

        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
        final UserDetails userDetails = loadUserByUsername(userName);

        jwtUtil.generateToken(userDetails);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        Utilisateur user = userDAO.findByUsername(userName).get();

        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setNom(user.getNom());
        userInfo.setPrenom(user.getPrenom());
        userInfo.setUserName(user.getUserName());
        userInfo.setUserPassword(user.getUserPassword());
        userInfo.setUserRoles(user.getRole());
        user.setDerniereConnexion(getLastLoginDate());
        userDAO.save(user);
        System.out.println("The last login date is:" + getLastLoginDate());
        return new JwtResponse(userInfo, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userDAO.findByUsername(username).get();
        if (user != null) {
            if (user.isStatus()) {
                return new org.springframework.security.core.userdetails.User(
                        user.getUserName(),
                        user.getUserPassword(),
                        getAuthorities(user)
                );
            } else {
                throw new UsernameNotFoundException("UserName Is not Valid");
            }
        } else {
            throw new UsernameNotFoundException("UserName Is not Valid");
        }
    }

    private Set getAuthorities(Utilisateur user) {
        Set authorities = new HashSet();
        user.getRole().forEach(role -> {
            // authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            for (String permission : getPermission(role)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + permission));
            }
        });
        return authorities;
    }

    private Set<String> getPermission(Role role) {
        Set<String> permissions = new HashSet();
        role.getPermission().forEach(permission ->
        {
            permissions.add(permission.getNomPermission());
        });
        return permissions;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("UserDisable");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credential From user");
        }
    }

} //End Subclass JWTService
