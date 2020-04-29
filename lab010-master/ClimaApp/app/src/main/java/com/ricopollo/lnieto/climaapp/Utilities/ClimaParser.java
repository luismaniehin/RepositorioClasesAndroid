package com.ricopollo.lnieto.climaapp.Utilities;

import com.ricopollo.lnieto.climaapp.Entities.Clima;
import com.ricopollo.lnieto.climaapp.Entities.CondicionActual;
import com.ricopollo.lnieto.climaapp.Entities.Nubes;
import com.ricopollo.lnieto.climaapp.Entities.Temperatura;
import com.ricopollo.lnieto.climaapp.Entities.Ubicacion;
import com.ricopollo.lnieto.climaapp.Entities.Viento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClimaParser {

    private static JSONObject mxObtenerObjeto(String tcTagNombre, JSONObject toJSONObject) throws JSONException {
        return toJSONObject.getJSONObject(tcTagNombre);
    }

    private static String mxObtenerString(String tcTagNombre, JSONObject toJSONObject) throws JSONException {
        return toJSONObject.getString(tcTagNombre);
    }

    private static float mxObtenerFloat(String tcTagNombre, JSONObject toJSONObject) throws JSONException {
        return (float) toJSONObject.getDouble(tcTagNombre);
    }

    private static int mxObtenerInt(String tcTagNombre, JSONObject toJSONObject) throws JSONException {
        return toJSONObject.getInt(tcTagNombre);
    }

    public static Clima mxObtenerClima(String tcDatos) throws JSONException {
        Clima loClima = new Clima();

        JSONObject loJSONObject = new JSONObject(tcDatos);
        Ubicacion loUbicacion = new Ubicacion();

        JSONObject loCoordenadas = mxObtenerObjeto("coord", loJSONObject);
        loUbicacion.mxEstablecerLatitud(mxObtenerFloat("lat", loCoordenadas));
        loUbicacion.mxEstablecerLongitud(mxObtenerFloat("lon", loCoordenadas));

        JSONObject loSys = mxObtenerObjeto("sys", loJSONObject);
        loUbicacion.mxEstablecerID(mxObtenerInt("id", loJSONObject));
        loUbicacion.mxEstablecerCiudad(mxObtenerString("name", loJSONObject));
        loUbicacion.mxEstablecerPais(mxObtenerString("country", loSys));
        loUbicacion.mxEstablecerSunrise(mxObtenerInt("sunrise", loSys));
        loUbicacion.mxEstablecerSunset(mxObtenerInt("sunset", loSys));
        loUbicacion.mxEstablecerDt(mxObtenerInt("dt", loJSONObject));

        loClima.poUbicacion = loUbicacion;

        JSONArray laJSONarray = loJSONObject.getJSONArray("weather");
        JSONObject loJSONClima = laJSONarray.getJSONObject(0);
        CondicionActual loCondicionActual = new CondicionActual();
        loCondicionActual.mxEstablecerIDClima(mxObtenerInt("id", loJSONClima));
        loCondicionActual.mxEstablecerDescripcion(mxObtenerString("description", loJSONClima));
        loCondicionActual.mxEstablecerCondicion(mxObtenerString("main", loJSONClima));
        loCondicionActual.mxEstablecerIcono(mxObtenerString("icon", loJSONClima));

        JSONObject loJSONmain = mxObtenerObjeto("main", loJSONObject);
        loCondicionActual.mxEstablecerHumedad(mxObtenerFloat("humidity", loJSONmain));
        loCondicionActual.mxEstablecerPresion(mxObtenerFloat("pressure", loJSONmain));
        Temperatura loTemperatura = new Temperatura();
        loTemperatura.mxEstablecerTemperatura(mxObtenerFloat("temp", loJSONmain));
        loTemperatura.mxEstablecerMaxTemp(mxObtenerFloat("temp_max", loJSONmain));
        loTemperatura.mxEstablecerMinTemp(mxObtenerFloat("temp_min", loJSONmain));

        loClima.poCondicionActual = loCondicionActual;
        loClima.poTemperatura = loTemperatura;

        JSONObject loJSONViento = mxObtenerObjeto("wind", loJSONObject);
        Viento loViento = new Viento();
        loViento.mxEstablecerVelocidad(mxObtenerFloat("speed", loJSONViento));
        loViento.mxEstablecerGrado(mxObtenerFloat("deg", loJSONViento));

        JSONObject loJSONNubes = mxObtenerObjeto("clouds", loJSONObject);
        Nubes loNubes = new Nubes();
        loNubes.mxEstablecerPorcentaje(mxObtenerInt("all", loJSONNubes));

        loClima.poViento = loViento;
        loClima.poNubes = loNubes;

        return loClima;
    }

}
