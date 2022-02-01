package fdsa.edu.pnu.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.Security
 * @Date: Sep 21, 2021
 * @Subclass JwtController Description:
 */
//Imports
//Begin Subclass JwtController
@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JWTService jwtService;

    @PostMapping("/authenticate")

    public JwtResponse createToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        JwtResponse jwtResponse = jwtService.createJwtToken(jwtRequest);
        return jwtResponse;
    }
    // @PostMapping({)
} //End Subclass JwtController
