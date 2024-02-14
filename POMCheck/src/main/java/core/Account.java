package core;

import lombok.*;

@Getter
@Setter
@ToString

public class Account {
    private String name;
    private String email;
    private String[] roles;
    private boolean admin;

    public Account(String name, String email, String[] roles, boolean admin) {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public static String torole(String[] arr){
        String s = "";
        for(int i = 0; i < arr.length; i++){
           s = arr[i].toString();
           if(!((i+1)== arr.length)){
                s += ", ";
            }
        }
        return  s;
    }
}
