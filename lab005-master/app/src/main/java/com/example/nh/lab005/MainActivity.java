package com.example.nh.lab005;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChat = new Button(this);
        btnChat = (Button) findViewById(R.id.btnChat);

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loIntento = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(loIntento);
            }
        });
    }
}
