package com.example.nh.lab09;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button bdoSomething;
    private Button bOpenWebPage;
    private Button bOpenMap;

    public static final  String EXTRA_MESSAGE = "MainActivity.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdoSomething = (Button) findViewById(R.id.b_do_something);
        bOpenWebPage = (Button) findViewById(R.id.b_open_webpage);
        bOpenMap = (Button) findViewById(R.id.b_open_map);

        bdoSomething.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                doSomething();
            }
        });

        bOpenWebPage.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openWebPage();
            }
        });

        bOpenMap.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMap();
            }
        });

    }

    private void openMap() {

        Uri geolocation = Uri.parse("geo:37.7749,-122,4194");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geolocation);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private void openWebPage(){

        Uri webpage = Uri.parse ("http://www.isur.edu.pe");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private void doSomething() {

        Intent intent = new Intent(this, ChildActivity.class);

        EditText editText = (EditText) findViewById(R.id.et_text_entry);
        String msg = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);

        startActivity(intent);

    }

}
