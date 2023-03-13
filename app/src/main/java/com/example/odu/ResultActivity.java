package com.example.odu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private EditText editTextAge, editTextGender, editTextBMI, editTextGenHealth, editTextPhysical, editTextMental, editTextSleep, editTextPhysicalAct, editTextSmoke, editTextAlcohol, editTextStroke, editTextWalking, editTextDiabetes, editTextAsthama, editTextKidney, editTextSkin;
    private Button buttonResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //initialization of all fields
        initialize();

        //adding listeners to fields
        addListeners();
    }

    private void addListeners() {
        buttonResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                //check contraints
                if( constraints() ){
                    if( editTextSmoke.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextAlcohol.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextWalking.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextStroke.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextKidney.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextSkin.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextAsthama.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextDiabetes.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( editTextPhysicalAct.getText().toString().equalsIgnoreCase("yes") ) {
                        ++ count;
                    }
                    if( Integer.parseInt(editTextPhysical.getText().toString()) < 10 ) {
                        ++ count;
                    }
                    if( Integer.parseInt(editTextMental.getText().toString()) < 10 ) {
                        ++ count;
                    }
                    if( Integer.parseInt(editTextSleep.getText().toString()) < 3 ) {
                        ++ count;
                    }
                    if( Integer.parseInt(editTextSleep.getText().toString()) < 3 ) {
                        ++ count;
                    }
                    if( Double.parseDouble(editTextSleep.getText().toString()) > 5 ) {
                        ++ count;
                    }
                }
                if( count > 5 ){
                    buttonResults.setText("Danger\nCheck again!");
                }else{
                    buttonResults.setText("Safe\nCheck again!");
                }
            }
        });

    }

    private boolean constraints() {
        if( Integer.parseInt(editTextAge.getText().toString()) < 0 && Integer.parseInt(editTextAge.getText().toString()) > 100 ){
            return false;
        }else if( !(editTextGender.getText().toString().equalsIgnoreCase("male") || editTextGender.getText().toString().equalsIgnoreCase("female") )){
            return false;
        }
        return true;
    }

    private void initialize() {
        editTextAge = findViewById(R.id.editTextAge);
        editTextGender = findViewById(R.id.editTextGender);
        editTextBMI = findViewById(R.id.editTextBMI);
        editTextGenHealth = findViewById(R.id.editTextGenHealth);
        editTextPhysical = findViewById(R.id.editTextPhysical);
        editTextMental = findViewById(R.id.editTextMental);
        editTextPhysicalAct = findViewById(R.id.editTextPhysicalAct);
        editTextSleep = findViewById(R.id.editTextSleep);
        editTextSmoke = findViewById(R.id.editTextSmoke);
        editTextAlcohol = findViewById(R.id.editTextAlcohol);
        editTextStroke = findViewById(R.id.editTextStroke);
        editTextWalking = findViewById(R.id.editTextWalking);
        editTextDiabetes = findViewById(R.id.editTextDiabetes);
        editTextAsthama = findViewById(R.id.editTextAsthma);
        editTextKidney = findViewById(R.id.editTextKidney);
        editTextSkin = findViewById(R.id.editTextSkin);

        buttonResults = findViewById(R.id.buttonResults);
    }
}