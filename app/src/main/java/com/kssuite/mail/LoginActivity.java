package com.kssuite.mail;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("KSMAIL", MODE_PRIVATE);
            prefs.edit()
                    .putString("email", email.getText().toString())
                    .putString("password", password.getText().toString())
                    .apply();

            startActivity(new Intent(LoginActivity.this, MainWebViewActivity.class));
        });
    }
}
