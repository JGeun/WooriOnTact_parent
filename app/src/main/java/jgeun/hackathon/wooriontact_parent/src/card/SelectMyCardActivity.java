package jgeun.hackathon.wooriontact_parent.src.card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.child.ChildInfoActivity;
import jgeun.hackathon.wooriontact_parent.src.child.SelectChildActivity;

public class SelectMyCardActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_my_card);

        registerButton = findViewById(R.id.select_btn_register);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select_btn_register:
                startActivity(new Intent(this, SelectChildActivity.class));
                break;
        }
    }
}