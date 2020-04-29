package com.ricopollo.lnieto.climaapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ricopollo.lnieto.climaapp.Entities.Clima;
import com.ricopollo.lnieto.climaapp.Utilities.ClimaConexion;
import com.ricopollo.lnieto.climaapp.Utilities.ClimaParser;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnBuscar;
    EditText txcCiudad;
    TextView lblCiudadNombre, lblIconoClima, txcTemperatura, lblDetalles, lblActualizacion,
             lblMaxTemp, lblMinTemp, lblPresion, lblHumedad;
    Typeface poMiFuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String lcCiudad = "Arequipa,pe";

        this.mxInicializarActivity();

        TareaJSONClima loTareaJSONClima = new TareaJSONClima();
        loTareaJSONClima.execute(new String[]{lcCiudad});
    }

    private void mxInicializarActivity(){
        txcCiudad = (EditText) findViewById(R.id.txcCiudad);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        lblCiudadNombre = (TextView) findViewById(R.id.lblCiudadNombre);
        lblIconoClima = (TextView) findViewById(R.id.lblIconoClima);
        txcTemperatura = (TextView) findViewById(R.id.txcTemperatura);
        lblDetalles = (TextView) findViewById(R.id.lblDetalles);
        lblActualizacion = (TextView) findViewById(R.id.lblActualizacion);
        lblMaxTemp = (TextView) findViewById(R.id.lblMaxTemp);
        lblMinTemp = (TextView) findViewById(R.id.lblMinTemp);
        lblPresion = (TextView) findViewById(R.id.lblPresion);
        lblHumedad = (TextView) findViewById(R.id.lblHumedad);

        this.poMiFuente = Typeface.createFromAsset(getAssets(), "weather.ttf");
        lblIconoClima.setTypeface(this.poMiFuente);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lcCiudad = txcCiudad.getText().toString().trim();

                TareaJSONClima loTareaJSONClima = new TareaJSONClima();
                loTareaJSONClima.execute(new String[]{lcCiudad});
            }
        });
    }

    private void mxObtenerIconoClima(int tnActualID, long tnManana, long tnTarde){
        int lnID = tnActualID / 100;
        String lcIcono = "";

        if(lnID == 800){
            long lnTiempoActual = new Date().getTime();

            if(lnTiempoActual >= tnManana && lnTiempoActual < tnTarde)
                lcIcono = getString(R.string.clima_soleado);
            else
                lcIcono = getString(R.string.clima_noche_despejada);
        }
        else{
            switch (lnID){
                case 2: lcIcono = getString(R.string.clima_truenos);
                    break;
                case 3: lcIcono = getString(R.string.clima_llovizna);
                    break;
                case 5: lcIcono = getString(R.string.clima_lluvia);
                    break;
                case 6: lcIcono = getString(R.string.clima_nieve);
                    break;
                case 7: lcIcono = getString(R.string.clima_bruma);
                    break;
                case 8: lcIcono = getString(R.string.clima_nubes);
                    break;
            }
        }

        lblIconoClima.setText(lcIcono);
    }

    private class TareaJSONClima extends AsyncTask<String, Void, Clima> {
        @Override
        protected Clima doInBackground(String... params) {
            Clima loClima = new Clima();
            String lcData = ( (new ClimaConexion()).mxObtenerDatosClima(params[0]));

            try {
                loClima = ClimaParser.mxObtenerClima(lcData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return loClima;
        }

        @Override
        protected void onPostExecute(Clima clima) {
            super.onPostExecute(clima);

            String lcMaxTemp, lcMinTemp, lcHumedad, lcPresion;
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            String lcFechaActualizacion = dateFormat.format(new Date(clima.poUbicacion.mxObtenerDt()*1000));

            lcMaxTemp = "Máx Temp: " + Math.round((clima.poTemperatura.mxObtenerMaxTemp() - 273.15)) + "°C";
            lcMinTemp = "Min Temp: " + Math.round((clima.poTemperatura.mxObtenerMinTemp() - 273.15)) + "°C";
            lcHumedad = "Humedad : " + clima.poCondicionActual.mxObtenerHumedad() + "%";
            lcPresion = "Presión : " + clima.poCondicionActual.mxObtenerPresion() + " hPa";

            lblCiudadNombre.setText(clima.poUbicacion.mxObtenerCiudad() + "," + clima.poUbicacion.mxObtenerPais());
            lblDetalles.setText(clima.poCondicionActual.mxObtenerCondicion() + "(" + clima.poCondicionActual.mxObtenerDescripcion() + ")");
            txcTemperatura.setText("" + Math.round((clima.poTemperatura.mxObtenerTemperatura() - 273.15)) + "°C");
            lblMaxTemp.setText(lcMaxTemp);
            lblMinTemp.setText(lcMinTemp);
            lblHumedad.setText(lcHumedad);
            lblPresion.setText(lcPresion);

            mxObtenerIconoClima((int)clima.poCondicionActual.mxObtenerIDClima(),
                    clima.poUbicacion.mxObtenerSunrise() * 1000,
                    clima.poUbicacion.mxObtenerSunset() * 1000);

            lblActualizacion.setText("Últ. Fecha Act. " + lcFechaActualizacion);
        }
    }

}
