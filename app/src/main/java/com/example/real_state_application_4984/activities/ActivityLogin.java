package com.example.real_state_application_4984.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.real_state_application_4984.R;

public class ActivityLogin extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.EmailLoginEdit);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button3);
        backBtn = findViewById(R.id.backBtn); // Initialize back button

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        // Implement back button functionality
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the main intro page (assuming MainActivity is the main intro page)
                Intent intent = new Intent(ActivityLogin.this, ActivitySignup.class);
                startActivity(intent);
                finish(); // Optional: finish the LoginActivity to prevent going back to it when pressing back
            }
        });
    }

    private void login() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validation checks and database operations
        // ...

        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

        // Proceed to MainActivity after successful login
        startActivity(new Intent(ActivityLogin.this, MainActivity.class));
    }
}
