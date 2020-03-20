package com.wzw.simulationcarutil;

import android.os.Bundle;

import com.wzw.simcarutillib.util.ParseUtil;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseUtil.appendRight2("0123",6);
    }
}
