package com.kuncham.kyetees;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button mRegBtn, mLogin_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        mRegBtn = (Button)findViewById(R.id.start_reg_btn);
        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg_intent = new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(reg_intent);
            }
        });

        mLogin_Btn = (Button) findViewById(R.id.start_login_btn);
        mLogin_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(login_intent);
            }
        });

    }
}
