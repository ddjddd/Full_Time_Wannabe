package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.model.Boss;
import pyneer.full_time_wannabe.model.Emp;

public class SignupActivity extends AppCompatActivity {
    private FirebaseDatabase fbDB = FirebaseDatabase.getInstance();
    private DatabaseReference dbRef = fbDB.getReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_boss)
    public void onBtnBossClick() {
        MaterialDialog dialog =
                new MaterialDialog.Builder(this)
                        .title("사장님으로 가입하기")
                        .customView(R.layout.dialog_signup, true)
                        .positiveText("가입")
                        .negativeText("취소")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                signup_boss(dialog.getCustomView());
                            }
                        })
                        .build();
        dialog.show();
    }

    @OnClick(R.id.btn_emp)
    public void onBtnEmpClick() {
        MaterialDialog dialog =
            new MaterialDialog.Builder(this)
                .title("직원으로 가입하기")
                .customView(R.layout.dialog_signup, true)
                .positiveText("가입")
                .negativeText("취소")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        signup_emp(dialog.getCustomView());
                    }
                })
                .build();
        dialog.show();
    }

    private void signup_emp(View view) {
        Emp newEmp = new Emp();

        newEmp.id = ((EditText) view.findViewById(R.id.ed_id)).getText().toString();
        newEmp.pw = ((EditText) view.findViewById(R.id.ed_pw)).getText().toString();
        newEmp.name = ((EditText) view.findViewById(R.id.ed_name)).getText().toString();
        newEmp.phone = ((EditText) view.findViewById(R.id.ed_phone)).getText().toString();
        newEmp.bank = " ";
        newEmp.account = " ";

        dbRef.child("emp").child(newEmp.id).setValue(newEmp);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", newEmp.id +" 로 회원가입 되셨습니다.");
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void signup_boss(View view) {
        Boss newBoss = new Boss();

        newBoss.id = ((EditText) view.findViewById(R.id.ed_id)).getText().toString();
        newBoss.pw = ((EditText) view.findViewById(R.id.ed_pw)).getText().toString();
        newBoss.name = ((EditText) view.findViewById(R.id.ed_name)).getText().toString();
        newBoss.phone = ((EditText) view.findViewById(R.id.ed_phone)).getText().toString();

        dbRef.child("boss").child(newBoss.id).setValue(newBoss);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", newBoss.id +" 로 회원가입 되셨습니다.");
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
