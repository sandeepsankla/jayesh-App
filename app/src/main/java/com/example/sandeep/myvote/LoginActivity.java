package com.example.sandeep.myvote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.afollestad.materialdialogs.MaterialDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email_text)
    EditText emailText;
    @BindView(R.id.pass_text)
    EditText passText;
    @BindView(R.id.submit_btn)
    Button submitBtn;
    @BindView(R.id.sign_up_btn)
    Button signUpBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        ButterKnife.bind(this);
        String selectedValue = null;
        if(getIntent().getExtras()!=null){
           selectedValue  = getIntent().getExtras().getString("selected_value");
        }
        if(selectedValue!= null && selectedValue.equalsIgnoreCase("admin")){
            //admin selected
            signUpBtn.setVisibility(View.GONE);
        } else if(selectedValue!= null && selectedValue.equalsIgnoreCase("user")){
            //user selected
            signUpBtn.setVisibility(View.VISIBLE);

        }
    }

    @OnClick({R.id.submit_btn, R.id.sign_up_btn, R.id.forgot_pass_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.submit_btn:
              boolean isValid =  validateInputs();
               if(isValid){
                   matchInputWithdb();
                   // move to otp screen
               }

                break;
            case R.id.sign_up_btn:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.forgot_pass_text:
                // do action

                break;
        }
    }

    private boolean matchInputWithdb() {
        String email = LocalStorage.getInstance().getKeyEmail();
        String pass = LocalStorage.getInstance().getKeyPassword();
        if(Utils.isNullorEmpty(email)){
            Toast.makeText(this, "Your email is not registered with us, Please do sign-up", Toast.LENGTH_SHORT).show();
        return false;
        } else if(!email.equalsIgnoreCase(emailText.getText().toString())){
            Toast.makeText(this, "Your email is incorrect, Please try with correct credentials", Toast.LENGTH_SHORT).show();
            return false;

        }else if(!pass.equalsIgnoreCase(passText.getText().toString())){
            Toast.makeText(this, "Your password is incorrect, Please try with correct credentials", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;
    }

    private boolean validateInputs() {

        if(!Utils.isValidEmail(emailText.getText())){
            emailText.setError("Please enter a valid email id");
            return false;
        }else if(!Utils.isValidPassWord(passText.getText())){
            passText.setError("Password should be at least 6 character long");
            return false;
        }
        return true;

    }
    private void showDialogProgress(){


    }
}
