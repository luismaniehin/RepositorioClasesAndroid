package com.example.nh.lab009;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nh.lab009.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText txcBusqueda;
    private TextView lblURL, lblBusqueda, lblRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txcBusqueda = (EditText) findViewById(R.id.txcBusqueda);
        lblBusqueda = (TextView) findViewById(R.id.lblBusqueda);
        lblRespuesta = (TextView) findViewById(R.id.lblRespuesta);
        lblURL = (TextView) findViewById(R.id.lblURL);

        lblBusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mxMostrarRespuestaJSON();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int lnItemClicked = item.getItemId();

        if(lnItemClicked == R.id.mnuBuscar){
            //Toast.makeText(MainActivity.this, "Mensaje de búsqueda", Toast.LENGTH_LONG).show();
            mxMostrarRespuestaJSON();
        }

        return true;
    }

    private String plRespuesta;
    private String pcQuery;

    public void mxMostrarRespuestaJSON() {
        String lcQuery = this.txcBusqueda.getText().toString();
        URL loUrl = NetworkUtils.buildUrl(lcQuery);

        //LLamarServicio loLLamarServicio = new LLamarServicio();
        //loLLamarServicio.execute(loUrl);

        //new LLamarServicio.execute(loUrl);
    }

    public class LLamarServicio extends AsyncTask<URL, Void, String>{
        @Override
        protected String doInBackground(URL... urls) {
            String lcRespuesta = null;

            try {
                URL loURL = urls[0];
                lcRespuesta = NetworkUtils.getResponseFromHttpUrl(loURL);
            }
            catch (IOException e){
                e.printStackTrace();
            }

            return lcRespuesta;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null)
                lblRespuesta.setText(s);
        }
    }

}
