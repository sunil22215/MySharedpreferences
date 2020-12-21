package com.example.mysharedpreferences1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sharedpref.init(getApplicationContext());
        initLayout();
        setListnerWithView();
    }

    private void initLayout() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSave = findViewById(R.id.buttonSave);

    }

    private void setListnerWithView() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String password = editTextPassword.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Name is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Password is Required", Toast.LENGTH_SHORT).show();
                    return;
                }

                registerUser(name, password);

            }
        });

    }

    private void registerUser(String name, String password) {
        Sharedpref.write(Sharedpref.name, name);
        Sharedpref.write(Sharedpref.password, password);
        Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}