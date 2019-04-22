package com.example.sandeep.myvote;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VotingActivity extends AppCompatActivity {

    @BindView(R.id.yuva_neta)
    RadioButton yuvaNeta;
    @BindView(R.id.gniotians)
    RadioButton gniotians;
    @BindView(R.id.future_india)
    RadioButton futureIndia;
    @BindView(R.id.young)
    RadioButton young;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!yuvaNeta.isChecked() && !gniotians.isChecked() &&  !futureIndia.isChecked() && !young.isChecked()){
                    Toast.makeText(VotingActivity.this, "Please choose any one for vote", Toast.LENGTH_SHORT).show();
                    return;
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(VotingActivity.this, "vote done", Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(VotingActivity.this, MainActivity.class));
                    }
                }, 500);
            }
        });
    }
}
