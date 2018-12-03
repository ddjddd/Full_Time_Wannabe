package pyneer.full_time_wannabe.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pyneer.full_time_wannabe.R;

public class ProfileActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




    }


    public void onClick(View view)
    {
        Intent intent = new Intent (this, EditWorkPlaceActivity.class); // this로 쓰면 안 될 거 같은데...? : 쓰면 되네.
        startActivity(intent);
    }
}
