package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;

import pyneer.full_time_wannabe.api.OnRestApiListener;
import pyneer.full_time_wannabe.api.RestApiResult;
import pyneer.full_time_wannabe.api.implement.LoginActivity.LoginResult;
import pyneer.full_time_wannabe.app.App;
import pyneer.full_time_wannabe.utility.SharedPreferencesUtil;

/**
 * Created by ddjdd on 2018-11-29.
 */

public class AttendanceActivity extends AppCompatActivity implements OnRestApiListener {




    @Override
    public void onRestApiDone(RestApiResult restApiResult) {
        switch (restApiResult.getApiName()) {
        }
    }
}
