package com.example.sandeep.myvote;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.admin_radio_btn)
    RadioButton adminRadioBtn;
    @BindView(R.id.user_radio_btn)
    RadioButton userRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        ButterKnife.bind(this);

    }

    public void onSubmitClick(View view) {
        Intent in = new Intent(this, LoginActivity.class);
        if (adminRadioBtn.isChecked()) {
             in.putExtra("selected_value", "admin");
            startActivity(in);
        } else if (userRadioBtn.isChecked()) {
            in.putExtra("selected_value", "user");
            startActivity(in);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
