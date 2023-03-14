package com.example.odu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private EditText editTextMental, editTextSmoke, editTextAlcohol;
    private String smoke, alcohol;
    private int mental;
    private Button buttonResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        //initialization of all fields
        initialize();

        //adding listeners to fields
        addListeners();

        //deconstruct();
        deconstruct();
    }

    private void deconstruct() {
        smoke = alcohol = "";
        mental = -1;
    }

    private void addListeners() {
        buttonResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( buttonResults.getText().toString().equalsIgnoreCase("get results!") ) {
                    //check contraints

                    int score = 0;
                    if (constraints()) {
                        if( smoke.equalsIgnoreCase("yes") ){
                            score += 4;
                        }
                        if( alcohol.equalsIgnoreCase("yes") ){
                            score += 4;
                        }
                        if( mental <= 2 ){
                            score += 1;
                        }
                        if( score <= 1 ){
                            score += 1;
                        }

                        if( score > 6 ){
                            buttonResults.setText("Safe\nRetry!");
                        }else{
                            buttonResults.setText("Danger\nRetry!");
                        }
                    }else{
                        Toast.makeText(ResultActivity.this, "Enter valid fields!", Toast.LENGTH_SHORT).show();
                    }
                    if (score > 5) {
                        buttonResults.setText("Danger\nCheck again!");
                    } else {
                        buttonResults.setText("Safe\nCheck again!");
                    }
                }else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private boolean constraints() {
        if( editTextMental.getText().toString().equalsIgnoreCase("") ){
            return false;
        }
        mental = Integer.parseInt(editTextMental.getText().toString());
        smoke = editTextSmoke.getText().toString();
        alcohol = editTextAlcohol.getText().toString();

        if( mental < 0 && mental > 5 ){
            return false;
        }else if( !(smoke.equalsIgnoreCase("yes") || smoke.equalsIgnoreCase(" no")) ){
            return false;
        }else if( !(alcohol.equalsIgnoreCase("yes") || alcohol.equalsIgnoreCase("no")) ){
            return false;
        }
        return true;
    }

    private void initialize() {
        editTextMental = findViewById(R.id.editTextMental);
        editTextSmoke = findViewById(R.id.editTextSmoke);
        editTextAlcohol = findViewById(R.id.editTextAlcohol);
        buttonResults = findViewById(R.id.buttonResults);
    }
}