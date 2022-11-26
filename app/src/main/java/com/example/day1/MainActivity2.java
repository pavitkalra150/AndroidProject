package com.example.day1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button myBtn = findViewById(R.id.button);
        ImageView image1 = findViewById(R.id.image1);
        //TWO WAYS OF IMPLEMENTING ONCLICK LISTENER

//        myBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        myBtn.setOnClickListener(view -> {
            flag = false;
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

            //to change image onclick button
            if(flag) {
                image1.setImageResource(R.drawable.done);
            } else{
                image1.setImageResource(R.drawable.ic_baseline_back_hand_24);
            }
        });
    }
}