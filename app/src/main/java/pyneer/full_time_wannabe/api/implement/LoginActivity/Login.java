package pyneer.full_time_wannabe.api.implement.LoginActivity;

import pyneer.full_time_wannabe.api.RestApi;
import pyneer.full_time_wannabe.api.RestApiResult;

public class Login extends RestApi {
    private String email;
    private String pw;

    public Login(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }
    @Override
    public Class<? extends RestApiResult> getResultClass() {
        return LoginResult.class;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}