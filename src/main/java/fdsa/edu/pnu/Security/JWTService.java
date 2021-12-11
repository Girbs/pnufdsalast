package fdsa.edu.pnu.Security;


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

import java.util.HashSet;
import java.util.Set;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.Security
 * @Date: Sep 20, 2021
 * @Subclass JWTService Description:
 */
//Imports
//Begin Subclass JWTService
@Service
public class JWTService implements UserDetailsService {

    @Autowired
    private UtilisateurDAO userDAO;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {

        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
        final UserDetails userDetails = loadUserByUsername(userName);
        jwtUtil.generateToken(userDetails);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        Utilisateur user = userDAO.findByUsername(userName).get();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(user.getUserName());
        userInfo.setUserPassword(user.getUserPassword());
        userInfo.setUserRoles(user.getRoles());
        return new JwtResponse(userInfo, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userDAO.findByUsername(username).get();
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthorities(user)
            );
        } else {
            throw new UsernameNotFoundException("UserName Is not Valid");
        }
    }

    private Set getAuthorities(Utilisateur user) {
        Set authorities = new HashSet();
        user.getRoles().forEach(role ->
        {
           // authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            authorities.add(new SimpleGrantedAuthority(       "ROLE_"+role.getPermission()));
        });
        return authorities;
    }

    private Set getPermission(Role role) {
        Set permissions = new HashSet();
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
