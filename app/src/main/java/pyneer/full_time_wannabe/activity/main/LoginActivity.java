package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.api.OnRestApiListener;
import pyneer.full_time_wannabe.api.RestApiResult;
import pyneer.full_time_wannabe.api.RestApiTask;
import pyneer.full_time_wannabe.api.implement.LoginActivity.LoginResult;
import pyneer.full_time_wannabe.api.implement.LoginActivity.Signup;
import pyneer.full_time_wannabe.app.App;
import pyneer.full_time_wannabe.utility.SharedPreferencesUtil;


/**
 * Log_in activity
 */

public class LoginActivity extends AppCompatActivity implements OnRestApiListener {
    @BindView(R.id.ed_email)
    EditText ed_email;
    @BindView(R.id.ed_password)
    EditText ed_password;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_signup)
    Button btn_signup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        String email, password;
        email = ed_email.getText().toString();
        password = ed_password.getText().toString();

        // 로그인 검증 시도
        if (email.length() < 5 || password.length() < 6) {
            Toast.makeText(this, "Fill all", Toast.LENGTH_LONG).show();
            // 메소드화 필요
        } else {
            // 로그인 검증 완료시 행동 추가
        }
    }

    @OnClick(R.id.btn_signup)
    public void onBtnSignup() {
        // 회원가입용 다이얼로그 생성
        MaterialDialog dialog =
                new MaterialDialog.Builder(this)
                        .title("가입")
                        .customView(R.layout.dialog_signup, true)
                        .positiveText("가입하기")
                        .negativeText(android.R.string.cancel)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                doRegister(dialog.getCustomView());
                            }
                        })
                        .build();
        dialog.show();

    }

    private void doRegister(View registerView) {
        String id = ((EditText) registerView.findViewById(R.id.ed_signup_id)).getText().toString();
        String pw = ((EditText) registerView.findViewById(R.id.ed_signup_password)).getText().toString();
        String name = ((EditText) registerView.findViewById(R.id.ed_signup_name)).getText().toString();
        Signup signup = new Signup();
        signup.setEmail(id);
        signup.setPw(pw);
        signup.setName(name);
        new RestApiTask(this).execute(signup);
    }

    @Override
    public void onRestApiDone(RestApiResult restApiResult) {
        switch (restApiResult.getApiName()) {
            case "login":
                LoginResult loginResult = (LoginResult) restApiResult;
                if (loginResult.getResult()) {
                    //로그인 성공
                    SharedPreferencesUtil.putString("user_email", loginResult.user.getEmail());
                    SharedPreferencesUtil.putString("user_pw", loginResult.user.getPw());
//                    Util.updateToken();
                    App.getAppInstance().setUser(loginResult.user);
                    //팀 선택 액티비티로 넘어감
                    startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                    finish();
                } else {
                    new MaterialDialog.Builder(this).content("로그인에 실패했습니다.").show();
                }
                break;
            case "signup":
                new MaterialDialog.Builder(this).content("가입이 완료되었습니다.").show();
                break;
        }
    }
}
