package pyneer.full_time_wannabe.utility;

import java.lang.reflect.Member;

import pyneer.full_time_wannabe.activity.MainActivity;
import pyneer.full_time_wannabe.activity.main.LoadingActivity;
import pyneer.full_time_wannabe.activity.main.LoginActivity;
import pyneer.full_time_wannabe.activity.main.MessengerActivity;
import pyneer.full_time_wannabe.activity.main.StatisticsActivity;

public class Constants {
    public static final Class[] ACTIVITES = {
            MainActivity.class,
            LoginActivity.class,
            MessengerActivity.class,
            LoginActivity.class,
            LoadingActivity.class,
            StatisticsActivity.class
    };
    public static final boolean DEBUG = true;
}
