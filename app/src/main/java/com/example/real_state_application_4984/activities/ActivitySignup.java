package com.example.real_state_application_4984.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.real_state_application_4984.R;

public class ActivitySignup extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button signupButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEditText = findViewById(R.id.editTextText2);
        emailEditText = findViewById(R.id.editTextText3);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        confirmPasswordEditText = findViewById(R.id.editTextTextPassword);
        signupButton = findViewById(R.id.button4);
        loginButton = findViewById(R.id.button3);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitySignup.this, ActivityLogin.class));
            }
        });
    }

    private void signup() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        // Validation checks and database operations
        // ...

        Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show();

        // Start ActivityLogin after successful signup
        startActivity(new Intent(ActivitySignup.this, ActivityLogin.class));
    }
}
