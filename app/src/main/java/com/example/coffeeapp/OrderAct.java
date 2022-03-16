package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class OrderAct extends AppCompatActivity {

    private String coffeeType;
        private String addToCoffee = "";
        private CheckBox cre;
        private CheckBox sug;
        private Button btnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        cre = (CheckBox) findViewById(R.id.creamChkBox);
        sug = (CheckBox) findViewById(R.id.sugarChkBox);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // To read coffee additions and assign to addToCoffee String
                if(cre.isChecked()){
                    addToCoffee = "Cream added";
                }
                if(sug.isChecked())
                    addToCoffee += "....Sugar added";

                // Define the return intent.. store values in the intent
                Intent returnIntent = new Intent();
                returnIntent.putExtra("coffee_Type",coffeeType);
                returnIntent.putExtra("addTo_Coffee",addToCoffee);

                // To send back the intent with the stored values
                setResult(RESULT_OK,returnIntent);
                finish();
            }

        });

    }

    public void selectCoffee(View v){

        switch(v.getId()){
            case R.id.radioDecaf:
                coffeeType = "Decaf";
                break;
            case R.id.radioExpresso:
                coffeeType = "Espressor";
                break;
            case R.id.radioColombian:
                coffeeType = "Colombian";
        }

    }

}