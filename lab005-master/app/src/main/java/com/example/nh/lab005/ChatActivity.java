package com.example.nh.lab005;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ListView lstChat = new ListView(this);
        lstChat = (ListView) findViewById(R.id.lstChat);

        Button btnChat = new Button(this);
        btnChat = (Button) findViewById(R.id.btnChat);

        final EditText txcMensaje = (EditText) findViewById(R.id.txcMensaje);

        String[] laChat = new String[]{""};
        final List<String> laMensajes = new ArrayList<String>(Arrays.asList(laChat));
        final ArrayAdapter<String> mensajesAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, laMensajes
        );

        lstChat.setAdapter(mensajesAdapter);

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //laMensajes.add(txcMensaje.getText().toString());
                //txcMensaje.setText("");

                //mensajesAdapter.notifyDataSetChanged();
            }
        });

    }
}
