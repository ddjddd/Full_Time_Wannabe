package pyneer.full_time_wannabe.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.api.OnRestApiListener;
import pyneer.full_time_wannabe.api.RestApiResult;
import pyneer.full_time_wannabe.api.implement.LoginActivity.LoginResult;
import pyneer.full_time_wannabe.app.App;
import pyneer.full_time_wannabe.utility.SharedPreferencesUtil;

public class EditWorkPlaceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_workplace);
    }

    public void onClick(View view)
    {
        finish();
    }


}
