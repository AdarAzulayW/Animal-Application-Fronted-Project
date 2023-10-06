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

import com.example.ourfinalapp.Model.Users;
import com.example.ourfinalapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    EditText editFirstName, editLastName, editPassword, editEmail;
    Button register;
    TextView alreadyRegister;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        register = findViewById(R.id.RegisterButton);
        alreadyRegister = findViewById(R.id.loginRedirectText);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFirstName = findViewById(R.id.editFirstName);
                String firstName = editFirstName.getText().toString();

                EditText editLastName = findViewById(R.id.editLastName);
                String lastName = editLastName.getText().toString();

                EditText editPassword = findViewById(R.id.editPassword);
                String password = editPassword.getText().toString();

                EditText editEmail = findViewById(R.id.editEmail);
                String email = editEmail.getText().toString();

                EditText editId = findViewById(R.id.editId);
                String id = editId.getText().toString();

                Users user = new Users(firstName, lastName, id, email, password);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users").child(user.Id);

                myRef.setValue(user);

                regFunc(email, password);
                goToLoginActivity();
            }
        });

        alreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginActivity();
            }
        });
    }


    public void goToLoginActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void regFunc(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
