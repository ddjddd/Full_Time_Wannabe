package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.app.App;
import pyneer.full_time_wannabe.model.ChatListData;
import pyneer.full_time_wannabe.utility.SharedPreferencesUtil;

/**
 * Created by ddjdd on 2018-11-29.
 */

public class AttendanceActivity extends AppCompatActivity {
    @BindView(R.id.tv_wp_title) TextView tv_wp_title;
    @BindView(R.id.tv_wp_time) TextView tv_wp_time;
    @BindView(R.id.tv_wp_alter) TextView tv_wp_alter;
    @BindView(R.id.tv_db_month) TextView tv_db_month;
    @BindView(R.id.tv_db_day) TextView tv_db_day;
    @BindView(R.id.tv_db_attend) TextView tv_db_attend;
    @BindView(R.id.tv_db_late) TextView tv_db_late;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        ButterKnife.bind(this);


        tv_wp_title.setText("GS 대방점");
        tv_wp_time.setText("12시 ~ 1시");
        tv_wp_alter.setText("홍길동");
    }

    @OnClick(R.id.btn_attend)
    public void onBtnAttendClick() {

    }

    @OnClick(R.id.btn_exit)
    public void onBtnExitClick() {

    }

}
