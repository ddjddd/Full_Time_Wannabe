package pyneer.full_time_wannabe.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.app.App;
import pyneer.full_time_wannabe.model.Emp;

public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.img_profile) CircleImageView img_profile;
    @BindView(R.id.tv_name) TextView tv_name;
    @BindView(R.id.tv_id) TextView tv_id;
    @BindView(R.id.tv_phone) TextView tv_phone;
    @BindView(R.id.lv_workplace) ListView lv_workplace;
    @BindView(R.id.tv_bank) TextView tv_bank;
    @BindView(R.id.tv_account) TextView tv_account;

    Emp currentEmp;

    private FirebaseDatabase fbDB = FirebaseDatabase.getInstance();
    private DatabaseReference dbRef = fbDB.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiile);
        ButterKnife.bind(this);

        currentEmp= App.getAppInstance().getEmp();
        fillBlank();
    }

    private void fillBlank() {
        tv_name.setText(currentEmp.name);
        tv_id.setText(String.format("[ %s ]", currentEmp.id));
        tv_phone.setText(currentEmp.phone);

        if(currentEmp.account.equals(" ") || currentEmp.bank.equals(" ")) {
            tv_account.setText("등록된 계좌가 없습니다.");
        }
        else {
            tv_bank.setText(currentEmp.bank);
            tv_account.setText(currentEmp.account);
        }
    }

    @OnClick(R.id.btn_logout)
    public void onBtnLogoutClick() {
        finish();
    }

    @OnClick(R.id.btn_withdraw)
    public void onBtnWithdrawClick() {

    }

    @OnClick(R.id.btn_phone)
    public void onBtnPhoneClick() {
        MaterialDialog dialog =
                new MaterialDialog.Builder(this)
                        .title("전화번호 변경하기")
                        .customView(R.layout.dialog_edit_phone, true)
                        .positiveText("변경")
                        .negativeText("취소")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                String newPhone = ((EditText) dialog.getCustomView().findViewById(R.id.ed_phone)).getText().toString();
                                currentEmp.phone = newPhone;
                                dbRef.child("emp").child(currentEmp.id).child("phone").setValue(newPhone);
                                tv_phone.setText(newPhone);
                            }
                        })
                        .theme(Theme.DARK)
                        .build();
        ((TextView)dialog.getCustomView().findViewById(R.id.ed_phone)).setText(currentEmp.phone);
        dialog.show();
    }

    @OnClick(R.id.btn_workplace)
    public void onBtnWorkplaceClick() {

    }

    @OnClick(R.id.btn_account)
    public void onBtnAccountClick() {
        MaterialDialog dialog =
                new MaterialDialog.Builder(this)
                        .title("전화번호 변경하기")
                        .customView(R.layout.dialog_edit_account, true)
                        .positiveText("변경")
                        .negativeText("취소")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                Spinner s = (Spinner)dialog.getCustomView().findViewById(R.id.spinner);
                                final TextView tv_selected = (TextView)dialog.getCustomView().findViewById(R.id.tv_selected);
                                s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view,
                                                               int position, long id) {
                                        tv_selected.setText(parent.getItemAtPosition(position).toString());
                                    }
                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {}
                                });

                                String bank = s.getSelectedItem().toString();
                                String account = ((EditText) dialog.getCustomView().findViewById(R.id.ed_account)).getText().toString();
                                currentEmp.account = account;
                                currentEmp.bank = bank;
                                dbRef.child("emp").child(currentEmp.id).setValue(currentEmp);
                                tv_bank.setText(bank);
                                tv_account.setText(account);
                            }
                        })
                        .theme(Theme.DARK)
                        .build();
        ((TextView)dialog.getCustomView().findViewById(R.id.tv_selected)).setText(currentEmp.bank);
        ((TextView)dialog.getCustomView().findViewById(R.id.ed_account)).setText(currentEmp.account);
        dialog.show();
    }

}
