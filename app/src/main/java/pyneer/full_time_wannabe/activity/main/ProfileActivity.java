package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.api.OnRestApiListener;
import pyneer.full_time_wannabe.api.RestApiResult;

public class ProfileActivity extends AppCompatActivity implements OnRestApiListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiile);


    }

    public void onClick(View view) {
        Intent intent = new Intent (this, EditWorkPlaceActivity.class); // this로 쓰면 안 될 거 같은데...? : 쓰면 되네.
        startActivity(intent);
    }


    @Override
    public void onRestApiDone(RestApiResult restApiResult) {
        switch (restApiResult.getApiName()) {

        }
    }
}
