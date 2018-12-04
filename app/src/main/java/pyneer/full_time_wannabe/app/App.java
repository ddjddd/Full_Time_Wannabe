package pyneer.full_time_wannabe.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

import pyneer.full_time_wannabe.model.User;

/**
 * Created by ddjdd on 2018-11-29.
 */

public class App extends Application {
    private static App instance;
    public static App getAppInstance() { return instance; }

    //접속한 유저.
    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    private HashMap<Integer, User> userMap;

    public User getUserById(int id) {
        return userMap.get(id);
    }

}