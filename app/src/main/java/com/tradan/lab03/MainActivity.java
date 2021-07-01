package com.tradan.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String TAG = "com.tradan.lab03.sharedprefs";
    Button bRight, bLeft;
    TextView tLeft, tRight;
    SeekBar seekBar;
    TextView[] views;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
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
        sharedPreferences = getSharedPreferences(TAG,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setInitialValues();
    }

    private void setInitialValues() {
        for (TextView x:views) {
            x.setText(sharedPreferences.getString(x.getTag().toString(),"0"));
        }
        seekBar.setProgress(30);
    }

    @Override
    public void onClick(View v) {
        TextView x = (TextView)v;
        x.setText(""+(Integer.parseInt(x.getText().toString())+1));
        editor.putString(x.getTag().toString(),x.getText().toString()).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setInitialValues();
    }
}