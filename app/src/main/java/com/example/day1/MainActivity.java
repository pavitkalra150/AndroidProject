package com.example.day1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEt;
    private EditText passwordEt;
    private Button regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.editTextTextPersonName);
        passwordEt = findViewById(R.id.Password);
        regBtn = findViewById(R.id.button);
        
    }

    public void register(View view){
        String name = nameEt.getText().toString();
        String password = passwordEt.getText().toString();
        if(!name.isEmpty() && !password.isEmpty()){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "name: " + name + "\n" + "password: " + password, Toast.LENGTH_SHORT).show();
        }
    }
}