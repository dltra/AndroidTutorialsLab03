package com.tradan.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bRight, bLeft;
    TextView tLeft, tRight;
    SeekBar seekBar;
    TextView[] views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bRight = findViewById(R.id.bottomright_button);
        bLeft = findViewById(R.id.bottomleft_button);
        tLeft = findViewById(R.id.topleft_textview);
        tRight = findViewById(R.id.topright_textview);
        seekBar = findViewById(R.id.seekbar);
        views = new TextView[]{bRight,bLeft,tRight,tLeft};
        bRight.setOnClickListener(this);
        bLeft.setOnClickListener(this);
        tLeft.setOnClickListener(this);
        tRight.setOnClickListener(this);
        setInitialValues();
    }

    private void setInitialValues() {
        for (TextView x:views) {x.setText("0");}
        seekBar.setProgress(30);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button) {
            Button x = (Button) v;
            x.setText(""+(Integer.parseInt(x.getText().toString())+1));
        } else {
            TextView x = (TextView)v;
            x.setText(""+(Integer.parseInt(x.getText().toString())+1));
        }
    }
}