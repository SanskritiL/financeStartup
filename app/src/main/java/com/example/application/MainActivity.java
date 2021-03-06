package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button register, login;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null){
                    Toast.makeText(MainActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(MainActivity.this, HomeActivity.class );
                    startActivity(myintent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please log in", Toast.LENGTH_SHORT).show();
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailID = email.getText().toString();
                String pwd = password.getText().toString();


                if(pwd.isEmpty() || emailID.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are empty", Toast.LENGTH_SHORT ).show();
                }
                else if(!(pwd.isEmpty() && emailID.isEmpty())) {


                  mFirebaseAuth.signInWithEmailAndPassword(emailID, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          Toast.makeText(MainActivity.this,"Auntheticating", Toast.LENGTH_SHORT ).show();
                          if(task.isSuccessful()){
                              Toast.makeText(MainActivity.this,"Logged in succesfully", Toast.LENGTH_SHORT ).show();

                          }
                          else{
                              Intent myintent = new Intent(MainActivity.this, HomeActivity.class);
                          }
                      }
                  });



                }
                else{
                    Toast.makeText(MainActivity.this,"Oops! Error", Toast.LENGTH_SHORT ).show();

                }



            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToRegister = new Intent(MainActivity.this, profileActivity.class );
                startActivity(intToRegister);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }





}
