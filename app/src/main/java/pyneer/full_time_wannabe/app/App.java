package pyneer.full_time_wannabe.app;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import java.lang.reflect.Method;
import java.util.HashMap;

import pyneer.full_time_wannabe.model.Boss;
import pyneer.full_time_wannabe.model.Emp;

/**
 * Created by ddjdd on 2018-11-29.
 */

public class App extends Application {
    private static App instance;
    public static App getAppInstance() { return instance; }

    private Emp emp;
    private Boss boss;
    private int userType;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public Boss getBoss() { return boss; }
    public Emp getEmp() {
        return emp;
    }
    public int getUserType() { return userType; }

    public void setBoss(Boss boss) { this.boss = boss; }
    public void setEmp(Emp emp) {
        this.emp = emp;
    }
    public void setUserType(int userType) { this.userType = userType; }

    private HashMap<Integer, Emp> userMap;

    public Emp getUserById(int id) {
        return userMap.get(id);
    }

}