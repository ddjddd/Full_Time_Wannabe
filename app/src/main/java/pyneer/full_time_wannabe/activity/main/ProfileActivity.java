package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.api.OnRestApiListener;
import pyneer.full_time_wannabe.api.RestApiResult;

public class ProfileActivity extends AppCompatActivity implements OnRestApiListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.img_profile) ImageView img_profile;
    @BindView(R.id.tv_name) TextView tv_name;
    @BindView(R.id.tv_id) TextView tv_id;
    @BindView(R.id.tv_phone) TextView tv_phone;
    @BindView(R.id.lv_workplace) ListView lv_workplace;
    @BindView(R.id.tv_account) TextView tv_account;

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiile);
        ButterKnife.bind(this);

        setToolBar();
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);        //커스터마이징 하기 위해 필요
        actionBar.setDisplayHomeAsUpEnabled(true);          // 뒤로가기 버튼
    }
//
//    @OnClick(R.id.btn_logout)
//    public void onBtnLogoutClick() {
//
//    }
//
//    @OnClick(R.id.btn_withdraw)
//    public void onBtnWithdrawClick() {
//
//    }
//
//    @OnClick(R.id.btn_phone)
//    public void onBtnPhoneClick() {
//
//    }
//
//    @OnClick(R.id.btn_workplace)
//    public void onBtnWorkplaceClick() {
//
//    }
//
//    @OnClick(R.id.btn_account)
//    public void onBtnAccountClick() {
//
//    }


    @Override
    public void onRestApiDone(RestApiResult restApiResult) {
        switch (restApiResult.getApiName()) {

        }
    }
}
