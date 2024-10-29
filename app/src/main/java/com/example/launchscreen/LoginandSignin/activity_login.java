package com.example.launchscreen.LoginandSignin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.launchscreen.HomeScreen.HomeActivities;
import com.example.launchscreen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_login extends AppCompatActivity {


    MaterialButton backbtn;
    Button Loginbtn;
    TextView tvSignU;

    EditText edtemail, edtpassword;
    private FirebaseAuth lAuth;

    CheckBox remember;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);

        backbtn = findViewById(R.id.backbtn);
        tvSignU = findViewById(R.id.tvSignUp2);
        Loginbtn = findViewById(R.id.btnLog);
        remember = findViewById(R.id.checkRememberMe);


        edtemail = findViewById(R.id.loginEmail);
        edtpassword = findViewById(R.id.loginPassword);

        lAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        checkLoginStatus();

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_login.this, SignInActivity.class));
                finish();
            }
        });
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();
                if (email.isEmpty()){
                    Toast.makeText(activity_login.this, "Please enter your email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()){
                    Toast.makeText(activity_login.this, "Please enter your password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                loginUser(email, password);
            }
        });
        tvSignU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_login.this, SignUp.class));
                finish();
            }
        });
    }

    private void checkLoginStatus() {
        boolean ischecked = sharedPreferences.getBoolean("rememberMe", false);
        if (ischecked) {
            // Nếu đã chọn Remember Me, chuyển đến MainActivity
            Intent intent = new Intent(activity_login.this, HomeActivities.class);
            startActivity(intent);
            finish();
        }
    }

    //nut dang nhap
    private void loginUser(String email, String password){
        lAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(activity_login.this, "Log in successful!", Toast.LENGTH_SHORT).show();

                    //checkbox remember
                    if (remember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("rememberMe", true);
                        editor.apply();
                    } else {
                        sharedPreferences.edit().clear().apply();
                    }

                    startActivity(new Intent(activity_login.this, HomeActivities.class));
                    finish();
                }
                else {
                    Toast.makeText(activity_login.this, "Đăng nhập thất bại: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}