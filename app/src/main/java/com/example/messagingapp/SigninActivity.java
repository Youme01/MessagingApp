package com.example.messagingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninActivity extends AppCompatActivity {

    TextView register ;
    EditText userEmail , userPassword;
    Button signbtn;

    public FirebaseUser currentUser;
    public FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        firebaseAuth = FirebaseAuth.getInstance();

        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        signbtn = findViewById(R.id.signinFloatingActionButton);
        register = findViewById(R.id.registerTextView);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this , RegisterActivity.class);
                finish();
                startActivity(intent);
            }
        });

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email,password).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(SigninActivity.this,"Done",Toast.LENGTH_SHORT);
                            sendToMainActivity();

                        }else{
                            String msg = task.getException().toString();

                        }

                    }
                });



            }
        });
    }
    public void onStart(){
        super.onStart();
        if(currentUser!=null){
            sendToMainActivity();
        }

    }

    private void sendToMainActivity() {

        Intent loginIntent = new Intent(SigninActivity.this,MainActivity.class);
        startActivity(loginIntent);
    }

}
