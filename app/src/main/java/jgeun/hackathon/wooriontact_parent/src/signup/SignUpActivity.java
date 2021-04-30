package jgeun.hackathon.wooriontact_parent.src.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.card.SelectMyCardActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout connectButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        connectButton = findViewById(R.id.signup_btn_connect);
        connectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup_btn_connect:
                startActivity(new Intent(this, SelectMyCardActivity.class));
                break;
        }

    }
}