package pyneer.full_time_wannabe.activity.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import pyneer.full_time_wannabe.R;

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
