package com.example.page.mylock;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private static final int SENSOR_SENSITIVITY = 4;
    RelativeLayout rl;
    RecyclerView recycler;
    RecyclerView recycler2;
    static RelativeLayout rel[]=new RelativeLayout[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);



        rl= (RelativeLayout) findViewById(R.id.act);
        rel[0]= (RelativeLayout) findViewById(R.id.rel1);
        rel[1]= (RelativeLayout) findViewById(R.id.rel2);
        rel[2]= (RelativeLayout) findViewById(R.id.rel3);
        rel[3]= (RelativeLayout) findViewById(R.id.rel4);

//       tv= (TextView) findViewById(R.id.txt);
        recycler= (RecyclerView) findViewById(R.id.recycler);
        recycler2= (RecyclerView) findViewById(R.id.recycler2);
        recycler2.setLayoutManager(new GridLayoutManager(this,3));
        recycler.setLayoutManager(new GridLayoutManager(this,3));


        //////////////////////// create random numbers ////////////////////////////////////
        int n=1;
        ArrayList<Integer> num=new ArrayList<>();
        int arrs[]=new int[11];
        while(n<10) {
            num.add(n);
            arrs[n-1]=n;
            n++;
        }
        num.add(0);
        arrs[10]=0;

        Collections.shuffle(num);
        num.add(num.get(9));

        key_adapter ka=new key_adapter(this,num);
        recycler.setAdapter(ka);

        key_adapter_original kas=new key_adapter_original(this,arrs,num);
        recycler2.setAdapter(kas);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] >= -SENSOR_SENSITIVITY && event.values[0] <= SENSOR_SENSITIVITY) {
                //near
                recycler.setVisibility(View.VISIBLE);
//                Toast.makeText(getApplicationContext(), "near", Toast.LENGTH_SHORT).show();
            } else {
                //far
               recycler.setVisibility(View.GONE);
//                Toast.makeText(getApplicationContext(), "far", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

