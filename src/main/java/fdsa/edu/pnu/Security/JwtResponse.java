package fdsa.edu.pnu.Security;


//@Data
//@Builder
////@AllArgsConstructor
//@NoArgsConstructor
public class JwtResponse {

    private UserInfo user;
    private String jwtToken;

    public JwtResponse(UserInfo user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
