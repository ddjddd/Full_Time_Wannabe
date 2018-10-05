package pyneer.full_time_wannabe.activity.main;

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

/**
 * 로그인화면
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editPassword)
    EditText editPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClickLogin() {
        String email, password;
        email = editEmail.getText().toString();
        password = editPassword.getText().toString();

        // 로그인 검증 시도
        if (email.length() < 5 || password.length() < 6) {
            Toast.makeText(this, "Fill all", Toast.LENGTH_LONG).show();
            // 메소드화 필요
        } else {
            // 로그인 검증 완료시 행동 추가
        }
    }

    @OnClick(R.id.btnSignup)
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
        // 회원가입 시 필요 행동 추가
    }
}
