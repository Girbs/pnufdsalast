package fdsa.edu.pnu.Security;

import fdsa.edu.pnu.Model.Role;

import java.util.Set;

public class UserInfo {

    private String userName;
    private String userPassword;
    private Set<Role> userRoles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
