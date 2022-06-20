package p1;


import java.util.List;

public class User {
    private String username;
    private String password;


    private String[][] accounts = { { "sadeem" }, { "s123" } };

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;

    }

    public String getPassword() {
        return password;

    }

    public void setUsername(String username) {
        this.username = username;

    }

    public void setPassword(String password) {
        this.password = password;

    }
    public boolean login() {

        if ((username.equals(accounts[0][0])) && (password.equals(accounts[1][0])))
            return true;
        else
            return false;
    }




}
