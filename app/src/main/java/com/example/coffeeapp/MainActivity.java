package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveTofrstAct(View v){
        Intent i = new Intent(getApplicationContext(), OrderAct.class);
        startActivityForResult(i,1);
    }

    public void moceToSec(View v){
        Intent i = new Intent(getApplicationContext(), RateAct.class);
        startActivityForResult(i,2);
    }
// to read the returned result
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //To read the result from first activity (order coffee)
        if(resultCode == RESULT_OK && requestCode == 1)
        {
            String order = "Order is: " + data.getStringExtra("coffee_Type") +
                    data.getStringExtra("addTo_Coffee");
            Toast.makeText(
                    getApplicationContext(), // Context
                    order, // Message
                    Toast.LENGTH_LONG // Short Duration
            ).show(); }

        // To open the intent from the second act

    }

}