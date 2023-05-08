package com.example.konify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button signInBtn;
    TextView registerLink;

    DbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signInBtn = findViewById(R.id.loginBtn);
        registerLink = findViewById(R.id.registerLink);

        helper = new DbAdapter(this);

        registerLink.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Register.class);
            startActivity(i);
        });

        signInBtn.setOnClickListener(v -> {
            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.isEmpty() || pass.isEmpty())
            {
                Message.message(getApplicationContext(),"Enter Both Name and Password");
            }
            else
            {
                boolean logged = helper.login(name, pass);
                if(logged)
                {
                    Message.message(getApplicationContext(),"Welcome "+name);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

                } else
                {
                    Message.message(getApplicationContext(),"Invalid Password/username");
                }
                username.setText("");
                password.setText("");
            }
        });
    }
}