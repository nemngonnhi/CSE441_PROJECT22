package com.example.launchscreen.LoginandSignin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.launchscreen.R;

public class SignInActivity extends AppCompatActivity {

    Button button;

    TextView tvSignU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        button = findViewById(R.id.btnLogin);
        tvSignU = findViewById(R.id.tvSignUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, activity_login.class));
                finish();
            }


        });
        tvSignU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, SignUp.class));
                finish();
            }
        });

    }
}