package com.example.tpintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        ((Button) findViewById(R.id.button1)).setOnClickListener(this);
        ((Button) findViewById(R.id.button2)).setOnClickListener(this);
        ((Button) findViewById(R.id.button3)).setOnClickListener(this);
        ((Button) findViewById(R.id.button4)).setOnClickListener(this);
        ((Button) findViewById(R.id.button5)).setOnClickListener(this);
        ((Button) findViewById(R.id.button6)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button1:
                intent = new Intent(this, ExplicitIntentActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, ExplicitIntentDataActivity.class);
                intent.putExtra("data", editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.button3:
                // navigate to Google.com
                // intent = new Intent(Intent.ACTION_VIEW);
                // intent.setData(android.net.Uri.parse("http://www.google.com"));
                // startActivity(intent);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                // with search
                //intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("http://www.google.com/search?q=" + editText.getText().toString()));
                startActivity(intent);
                break;
            case R.id.button4:
                // Application Settings
                intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                break;
            case R.id.button5:
                // make a call
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123456789"));
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
                break;
            case R.id.button6:
                // send an email
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abbassimelek@gmail.com", "test@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "From TPIntent");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello World!");
                startActivity(Intent.createChooser(intent, "Send Email"));
                break;
        }
    }
}