package com.example.chatqf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white)); // making the text ChatQF and the back button in white

        final PinEntryEditText pinEntry = (PinEntryEditText) findViewById(R.id.txt_pin_entry);

        if (pinEntry != null) {
            pinEntry.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
                @Override
                public void onPinEntered(CharSequence str) {
                    if (str.toString().equals("5555")) {
                        Toast.makeText(MainActivity2.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        Toast.makeText(MainActivity2.this, "FAIL", Toast.LENGTH_SHORT).show();
                        pinEntry.setText(null);
                    }
                }
            });
        }

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


