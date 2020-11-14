package com.example.chatqf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText number;
    Button btnSendOtp;
    String temp;
    private static final String NUMBER = "num";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white)); // making the text ChatQF and the back button in white

        number = findViewById(R.id.editText);

        btnSendOtp = findViewById(R.id.btnSendOTP);
        btnSendOtp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSendOTP:
                if ((""+number.getText().toString()).isEmpty()){ // casting to string
                    number.setError("Enter Your number plz !!");
                    return;
                }

                if ((number.getText().toString().length())!=13){
                    number.setError("Enter 13 digit number plz !! ");
                    return;
                }

                Intent outIntent = new Intent(MainActivity.this,MainActivity2.class);
                temp = number.getText().toString();
                outIntent.putExtra(NUMBER,temp);
                startActivity(outIntent);
                break;

        }
    }
}
