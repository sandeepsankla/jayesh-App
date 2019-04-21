package com.example.sandeep.myvote;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.name_et)
    EditText nameEt;
    @BindView(R.id.mobile_et)
    EditText mobileEt;
    @BindView(R.id.id_et)
    EditText idEt;
    @BindView(R.id.email_et)
    EditText emailEt;
    @BindView(R.id.pass_et)
    EditText passEt;
    @BindView(R.id.conf_pass_et)
    EditText confPassEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register_button)
    public void onViewClicked() {
        boolean isValid = validateInputs();
        if (isValid) {
            Intent in = new Intent(this, LoginActivity.class);
            in.putExtra("selected_value", "admin");
            startActivity(in);
        }
    }

    private boolean validateInputs() {
        if(Utils.isNullorEmpty(nameEt.getText())){
            nameEt.setError("Please enter name");
            return false;
        }else if(!Utils.isValidMobile(mobileEt.getText())) {
            mobileEt.setError("Please enter correct mobile number");
        }else if(Utils.isNullorEmpty(idEt.getText())) {
            idEt.setError("Please enter correct college id");
            return false;
        }else if(!Utils.isValidEmail(emailEt.getText())){
            emailEt.setError("Please enter correct email-id");
            return false;
        }else if(!Utils.isValidPassWord(passEt.getText())){
            passEt.setError("Password should be at least 6 character long");
            return false;
        }else if(Utils.isNullorEmpty(confPassEt.getText()) &&  !confPassEt.getText().toString().equalsIgnoreCase(passEt.getText().toString())){
            nameEt.setError("Confirm Password password are not same");
            return false;
        }

        //for storing local db
        LocalStorage.getInstance().saveUserEmail(emailEt.getText().toString());
        LocalStorage.getInstance().saveUserPassword(passEt.getText().toString());
        return true;

    }
}
