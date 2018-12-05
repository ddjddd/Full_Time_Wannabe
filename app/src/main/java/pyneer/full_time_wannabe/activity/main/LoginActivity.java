package pyneer.full_time_wannabe.activity.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.app.App;
import pyneer.full_time_wannabe.model.Boss;
import pyneer.full_time_wannabe.model.Emp;
import pyneer.full_time_wannabe.utility.Constants;


/**
 * Log_in activity
 */

public class LoginActivity extends AppCompatActivity{
    @BindView(R.id.ed_id) EditText ed_id;
    @BindView(R.id.ed_password) EditText ed_password;
    @BindView(R.id.rd_boss) RadioButton rd_boss;
    @BindView(R.id.rd_emp) RadioButton rd_emp;

    private FirebaseDatabase fbDB = FirebaseDatabase.getInstance();
    private DatabaseReference dbRef = fbDB.getReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        requestAppPermissions();
    }

    int REQUEST_WRITE_STORAGE_REQUEST_CODE = 100;
    private void requestAppPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(LoginActivity.this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 1234);
            }
        }

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, REQUEST_WRITE_STORAGE_REQUEST_CODE);
    }

    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }


    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        final String id, pw;
        id = ed_id.getText().toString();
        pw = ed_password.getText().toString();




        // Login As Boss
        if(rd_boss.isChecked()) {
            Query q = dbRef.child("boss").orderByKey().limitToFirst(1).equalTo(id);
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                        Boss get = postSnapshot.getValue(Boss.class);
                        if(get.pw.equals(pw)) {
//                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
//                            App.getAppInstance().setBoss(get);
//                            App.getAppInstance().setUserType(Constants.BOSS_USER);
//                            startActivityForResult(intent, 1);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "아이디 없음", Toast.LENGTH_LONG).show();
                }
            });
        }
        else if(rd_emp.isChecked()) {
            Query q = dbRef.child("emp").orderByKey().limitToFirst(1).equalTo(id);
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                        Emp get = postSnapshot.getValue(Emp.class);
                        if(get.pw.equals(pw)) {
                            App.getAppInstance().setEmp(get);
                            App.getAppInstance().setUserType(Constants.EMP_USER);
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "아이디 없음", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @OnClick(R.id.btn_signup_emp)
    public void onBtnSignup() {
        Intent intent = new Intent(this, SignupActivity.class);
        this.startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String ret = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), ret, Toast.LENGTH_LONG).show();
            }
        }
    }
}
