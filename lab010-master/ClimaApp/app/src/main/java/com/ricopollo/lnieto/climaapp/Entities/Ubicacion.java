package com.ricopollo.lnieto.climaapp.Entities;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private long pnID;
    private String pcCiudad;
    private String pcPais;
    private float pnLongitud;
    private float pnLatitud;
    private long pnSunset;
    private long pnSunrise;
    private long pnDt;

    //Getters
    public long mxObtenerID(){ return this.pnID; }
    public String mxObtenerCiudad(){ return this.pcCiudad; }
    public String mxObtenerPais(){ return this.pcPais; }
    public float mxObtenerLongitud(){ return this.pnLongitud; }
    public float mxObtenerLatitud(){ return this.pnLatitud; }
    public long mxObtenerSunset(){ return this.pnSunset; }
    public long mxObtenerSunrise(){ return this.pnSunrise; }
    public long mxObtenerDt() { return this.pnDt; }

    //Setters
    public void mxEstablecerID(long tnID) { this.pnID = tnID; }
    public void mxEstablecerCiudad(String tcCiudad) { this.pcCiudad = tcCiudad; }
    public void mxEstablecerPais(String tcPais) { this.pcPais = tcPais; }
    public void mxEstablecerLongitud(float tnLongitud) { this.pnLongitud = tnLongitud; }
    public void mxEstablecerLatitud(float tnLatitud) { this.pnLatitud = tnLatitud; }
    public void mxEstablecerSunset(long tnSunset) { this.pnSunset = tnSunset; }
    public void mxEstablecerSunrise(long tnSunrise) { this.pnSunrise = tnSunrise; }
    public void mxEstablecerDt(long tnDt) { this.pnDt = tnDt; }
}
