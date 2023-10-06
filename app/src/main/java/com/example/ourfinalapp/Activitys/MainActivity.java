package com.example.ourfinalapp.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfinalapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    String stringEmail, stringPassword;
    Button button;
    TextView registerText;
    private FirebaseAuth mAuth;
    protected DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        registerText = findViewById(R.id.registerText);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        button = findViewById(R.id.login_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringEmail = email.getText().toString();
                stringPassword = password.getText().toString();
                loginFunc(stringEmail, stringPassword);
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegActivity();
            }
        });
    }

    public void goToRegActivity()
    {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void goToHomePageActivity()
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void loginFunc(String email , String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "isSuccessful Login",
                                    Toast.LENGTH_SHORT).show();
                            goToHomePageActivity();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}