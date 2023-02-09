package com.example.tpintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitIntentDataActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_data);

        Intent intent = getIntent();

        String data = "";

        if (intent != null) {
            if (intent.hasExtra("data")) {
                data = intent.getStringExtra("data");
            }
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(data);
        }
    }
}