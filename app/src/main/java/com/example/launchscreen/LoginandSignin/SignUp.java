package com.example.launchscreen.LoginandSignin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.launchscreen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.Firebase.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    MaterialButton back;
    Button btnsignU;

    //dang ki
    EditText edtEmail, edtPassword, edtReEnterPassword, edtName;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        back = findViewById(R.id.backbtn);
        btnsignU = findViewById(R.id.btnSUp);

        edtEmail = findViewById(R.id.editSignUpEmail);
        edtPassword = findViewById(R.id.editSignUpPassword);
        edtReEnterPassword = findViewById(R.id.editReEnterPassword);
        edtName = findViewById(R.id.editNameofUser);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, SignInActivity.class));
                finish();
            }


        });

        //nut dki

        btnsignU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String confirmPassword = edtReEnterPassword.getText().toString().trim();
                String name = edtName.getText().toString();

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || name.isEmpty()){
                    Toast.makeText(SignUp.this, "Please fill in all information!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)){
                    Toast.makeText(SignUp.this, "Your confirm password don't match!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!email.contains("@")){
                    Toast.makeText(SignUp.this, "Please enter correct Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<8){
                    Toast.makeText(SignUp.this, "Password too short, password must contain at lease 8 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                signUpUser(email,password,name);
            }
        });
    }
    private void signUpUser(String email, String password, String name){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String userID = mAuth.getCurrentUser().getUid();
                    mDatabase.child("user").child(userID).child("name").setValue(name);

                    Toast.makeText(SignUp.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this, activity_login.class));
                    finish();
                }
                else{
                    Toast.makeText(SignUp.this, "Sign up failed!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}