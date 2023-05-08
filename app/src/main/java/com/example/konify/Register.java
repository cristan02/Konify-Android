package com.example.konify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    EditText email, username, password;
    Button signUpBtn;
    TextView loginLink;
    DbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signUpBtn = findViewById(R.id.registerBtn);
        loginLink = findViewById(R.id.loginLink);

        helper = new DbAdapter(this);

        loginLink.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
        });

        signUpBtn.setOnClickListener(v -> {
            String eMail = email.getText().toString();
            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(eMail.isEmpty() || name.isEmpty() || pass.isEmpty())
            {
                Message.message(getApplicationContext(),"Enter all details");
            }
            else
            {
                long id = helper.insertData(eMail, name, pass);
                if(id<=0)
                {
                    Message.message(getApplicationContext(),"Registration Unsuccessful");

                } else
                {
                    Message.message(getApplicationContext(),"Registration Successful");
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
                email.setText("");
                username.setText("");
                password.setText("");
            }
        });
    }
}