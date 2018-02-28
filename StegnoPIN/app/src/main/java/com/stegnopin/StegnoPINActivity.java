package com.stegnopin;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class StegnoPINActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stegno_pin);

        final Button buttonChallengeKeypad = (Button) findViewById(R.id.buttonChallengeKeypad);
        final Button buttonResponseKeypad = (Button) findViewById(R.id.buttonResponseKeypad);

        buttonChallengeKeypad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.lastKeypadType = "input";
                startActivity(new Intent(StegnoPINActivity.this,PinActivity.class));
                buttonResponseKeypad.setEnabled(true);
            }
        });

        buttonResponseKeypad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.lastKeypadType = "response";
                startActivity(new Intent(StegnoPINActivity.this,PinActivity.class));
            }
        });

    }
}
