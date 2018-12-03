package pyneer.full_time_wannabe.utility;

import pyneer.full_time_wannabe.activity.MainActivity;
import pyneer.full_time_wannabe.activity.main.AttendanceActivity;
import pyneer.full_time_wannabe.activity.main.ChatActivity;
import pyneer.full_time_wannabe.activity.main.MessengerActivity;
import pyneer.full_time_wannabe.activity.main.LoadingActivity;
import pyneer.full_time_wannabe.activity.main.LoginActivity;
import pyneer.full_time_wannabe.activity.main.ProfileActivity;
import pyneer.full_time_wannabe.activity.main.StatisticsActivity;

public class Constants {
    public static final Class[] ACTIVITES = {
            MainActivity.class,
            LoginActivity.class,
            MessengerActivity.class,
            LoadingActivity.class,
            StatisticsActivity.class,
            AttendanceActivity.class,
            ProfileActivity.class
    };
    public static final boolean DEBUG = true;
}
