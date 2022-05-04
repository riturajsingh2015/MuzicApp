package com.example.riturajsingh.muzicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ///Get Home Button and set OnClickListeners on it redirecting them to corrspoding activities using Explicit Intents
        Button homeButton = findViewById(R.id.payment_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetailsOfSong = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(goToDetailsOfSong);
            }
        });

    }

}
