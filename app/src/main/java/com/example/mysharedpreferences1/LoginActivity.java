package com.example.mysharedpreferences1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.mysharedpreferences1.Sharedpref.read;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Sharedpref.init(getApplicationContext());
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        setListenerWithView();
        

    }

    private void setListenerWithView() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Name is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Password is Required", Toast.LENGTH_SHORT).show();
                    return;
                }

                loginUser(name, password);

            }


        });

    }

    private void loginUser(String name, String password) {
        String savename = read(Sharedpref.name, "");
        String savepassword = read(Sharedpref.password, "");

        if (savename.equals(name) && savepassword.equals(password)) {
            Toast.makeText(LoginActivity.this, "login Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));

        } else {
            Toast.makeText(LoginActivity.this, "login failed", Toast.LENGTH_SHORT).show();

        }


    }

}