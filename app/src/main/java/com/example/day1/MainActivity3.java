package com.example.day1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    ViewGroup root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    root = findViewById(R.id.layout);

        CheckBox chk = findViewById(R.id.check);
        RadioGroup rg = findViewById(R.id.group);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(
                v ->{
                    if(chk.isChecked()){
                        int dealId = rg.getCheckedRadioButtonId();
                        
                        
                        String deal = ((RadioButton) findViewById(dealId)).getText().toString();
                        
                        
//                        switch(dealId){
//                            case R.id.first:
//                                deal = "jacket";
//                                break;
//                            case R.id.second:
//                                deal = "Shoes";
//                                break;
//                            case R.id.third:
//                                deal = "Exam";
//                                break;
//                            default:
//                                deal = "You need to pay more";
//                        }
                        Toast.makeText(this, deal, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Please check the checkbox", Toast.LENGTH_SHORT).show();
                    }
                }
        );


        //IMPLEMENTING LISTENER ON CHECKBOX ---------------
        chk.setOnCheckedChangeListener( (button , isChecked) -> {
            if(isChecked){
                Toast.makeText(this, "Agreed", Toast.LENGTH_SHORT).show();
            }
        });

        //IF IMPLEMENTING LISTENER ON ACTIVITY THIS IS REQUIRED -----------------

        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.third).setOnClickListener(this);
    }

    //AFTER IMPLEMENTING LISTENER ON THE ACTIVITY -------------

    @Override
    public void onClick(View view) {
        String text;
        switch(view.getId()){
            case R.id.first:
               text = "jacket is clicked";
                break;
            case R.id.second:
               text = "shoes is clicked";
                break;
            case R.id.third:
                text = "Exam is clicked";
                break;
            default:
                text = "something is going on";
        }

        //JUST AN ALERT WITH MESSAGE -----------

        //Snackbar.make(root, text , Snackbar.LENGTH_SHORT).show();


        //JUST AN ALERT WITH OK ACTION -------------

//        Snackbar.make(root, text , Snackbar.LENGTH_SHORT).setAction("Ok", v -> {
//            // TODO: SHOW ALERT
//        }).show();


        //MAKING A SNACKBAR WHICH IS LIKE AN ALERT AND THEN FURTHER MAKING A ALERTDIALOG  -------------

        Snackbar.make(root, text , Snackbar.LENGTH_SHORT).setAction("Ok", v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(text);
            builder.setIcon(R.drawable.done);

            //ONE WAY OF PERFORMING ACTION ON PRESSING OK IN ALERT ----------------

            //builder.setPositiveButton("OK", showToastMessage(text));

            // SECOND WAY OF PERFORMING ACTION ON PRESSING OK IN ALERT  -----------------

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity3.this, "Great", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.create().show();

        }).show();

    }


    //FUNCTION USED ON PRESSING OK IN ALERT DIALOG ---------------

    private DialogInterface.OnClickListener showToastMessage(String text){
        Toast.makeText(this, "text", Toast.LENGTH_SHORT).show();
        return null;
    }
}