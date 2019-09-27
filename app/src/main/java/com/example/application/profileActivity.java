package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class profileActivity extends AppCompatActivity {

    EditText email, password;
    Button btnSignUp, login;
    FirebaseAuth mFirebaseAuth;
    TextView tvSignIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.signUp);
        tvSignIn = findViewById(R.id.textView);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailID = email.getText().toString();
                String pwd = password.getText().toString();


                if(pwd.isEmpty() || emailID.isEmpty()){
                    Toast.makeText(profileActivity.this,"Fields are empty", Toast.LENGTH_SHORT ).show();
                }
                else if(!(pwd.isEmpty() && emailID.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(emailID, pwd).addOnCompleteListener(profileActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(profileActivity.this,"SignUp unsuccessfull", Toast.LENGTH_SHORT ).show();

                            }
                            else{
                                startActivity(new Intent(profileActivity.this, HomeActivity.class));
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(profileActivity.this,"Oops! Error", Toast.LENGTH_SHORT ).show();

                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(profileActivity.this, HomeActivity.class );
                startActivity(myintent);
            }
        });


    }
}
