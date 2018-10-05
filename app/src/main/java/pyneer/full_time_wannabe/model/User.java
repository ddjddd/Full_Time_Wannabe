package pyneer.full_time_wannabe.model;

/**
 * Default User Model
 */

public class User {
    private int id;             // DB key value
    private String email;       // user ID(email form)
    private String pw;          // user password

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPw() { return pw; }

    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) { this.email = email; }
    public void setPw(String pw) { this.pw = pw; }
}
