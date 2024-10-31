package com.example.launchscreen.HomeScreen.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.launchscreen.LoginandSignin.SignInActivity;
import com.example.launchscreen.LoginandSignin.activity_login;
import com.example.launchscreen.MainActivity;
import com.example.launchscreen.R;
import com.google.firebase.auth.FirebaseAuth;

public class SettingActivity extends AppCompatActivity {

    Button logOutbtn;
    Button upLoadAnEntity;

    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        logOutbtn = findViewById(R.id.btnLogOut);
        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        upLoadAnEntity = findViewById(R.id.btnUploadEntity);


        logOutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOutUser();
            }
        });
        upLoadAnEntity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, UploadEntities.class));
                finish();
            }
        });

    }
    private void logOutUser(){
        mAuth.signOut();

        //xoa remember me
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        //ve man hinh dang nhap
        Intent intent = new Intent(SettingActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}