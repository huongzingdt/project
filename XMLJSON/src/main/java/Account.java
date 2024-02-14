import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor

public class Account {
    private int id;
    private String name;
    private String[] roles;
    private boolean admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Account(int id, String name, String[] roles, boolean admin) {
        this.id = id;
        this.name = name;
        this.roles = roles;
        this.admin = admin;
    }
}
