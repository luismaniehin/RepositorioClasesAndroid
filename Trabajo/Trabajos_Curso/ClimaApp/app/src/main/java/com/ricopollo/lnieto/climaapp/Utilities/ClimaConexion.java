package com.ricopollo.lnieto.climaapp.Utilities;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClimaConexion {

    final static String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    final static String pcIDClave = "&APPID=a7b3bb59436ee7a844e4ea06b8a5556b";
    //final static String miURL = "http://api.openweathermap.org/data/2.5/weather?q=Arequipa,PE&APPID=f524bb50e14fa8a373ce6ec8b3e584bc";

    public String mxObtenerDatosClima(String tcCiudad) {
        HttpURLConnection loConexion = null ;
        InputStream loInputStream = null;

        try {
            loConexion = (HttpURLConnection) ( new URL(WEATHER_URL + tcCiudad + pcIDClave)).openConnection();
            //con = (HttpURLConnection) ( new URL(miURL)).openConnection();
            loConexion.setRequestMethod("GET");
            loConexion.setDoInput(true);
            loConexion.setDoOutput(true);
            loConexion.connect();

            StringBuffer lcBuffer = new StringBuffer();
            loInputStream = loConexion.getInputStream();

            BufferedReader loBufferedReader = new BufferedReader(new InputStreamReader(loInputStream));
            String lcLinea = null;
            while (  (lcLinea = loBufferedReader.readLine()) != null )
                lcBuffer.append(lcLinea + "\r\n");

            loInputStream.close();
            loConexion.disconnect();
            return lcBuffer.toString();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { loInputStream.close(); } catch(Throwable t) {}
            try { loConexion.disconnect(); } catch(Throwable t) {}
        }

        return null;
    }

}
