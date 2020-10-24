package com.example.codeada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import androidx.appcompat.app.ActionBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        Button generateButton = (Button) findViewById(R.id.button);
        TextView generateTextView = (TextView) findViewById(R.id.text1);
        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("here", "here");
                ArrayList<String> quotes = new ArrayList<String>();
                BufferedReader br = null;
                String line = "";
                BufferedInputStream bufferedInputStream = new BufferedInputStream(getResources().openRawResource(R.raw.quotes));
                br = new BufferedReader(new InputStreamReader(bufferedInputStream));
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("here", line);


                while (true) {
                    try {
                        Log.d("in second try", "in second try");
                        if (!((line = br.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    quotes.add(line);
                }
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Random randNum = new Random();
                int number = randNum.nextInt(quotes.size());
                generateTextView.setText(quotes.get(number));
            }
        });
    }
}