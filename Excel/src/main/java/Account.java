public class Account {
    private String username;
    private String email;
    private String mobile;
    private String[] roles;
    private boolean isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Account(String username, String email, String mobile, String[] roles, boolean isAdmin) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.roles = roles;
        this.isAdmin = isAdmin;
    }
}
