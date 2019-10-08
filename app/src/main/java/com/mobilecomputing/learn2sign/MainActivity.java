package com.mobilecomputing.learn2sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private boolean isSpinnerTouched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.word_arrays, R.layout.word_spinner_item);
        adapter.setDropDownViewResource(R.layout.word_droopdown_item);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        // without this, spinner will get selected automatically
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String str = (String) arg0.getSelectedItem();

                //here print selected value...
                System.out.println("String is :: " + str);

                //And StartActivity here...

                if(isSpinnerTouched && !str.equals("Choose Action Here")){
                    Intent intent = new Intent(MainActivity.this,PlayHelpVideo.class);
                    intent.putExtra("sign", str);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}
