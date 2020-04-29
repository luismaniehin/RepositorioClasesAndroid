package com.ricopollo.lnieto.climaapp.Entities;

public class Temperatura {
    private float pnTemperatura;
    private float pnMaxTemp;
    private float pnMinTemp;

    //Getters
    public float mxObtenerTemperatura() { return this.pnTemperatura; }
    public float mxObtenerMaxTemp() { return this.pnMaxTemp; }
    public float mxObtenerMinTemp() { return this.pnMinTemp; }

    //Setters
    public void mxEstablecerTemperatura(float tnTemperatura) { this.pnTemperatura = tnTemperatura; }
    public void mxEstablecerMaxTemp(float tnMaxTemp) { this.pnMaxTemp = tnMaxTemp; }
    public void mxEstablecerMinTemp(float tnMinTemp) { this.pnMinTemp = tnMinTemp; }
}
