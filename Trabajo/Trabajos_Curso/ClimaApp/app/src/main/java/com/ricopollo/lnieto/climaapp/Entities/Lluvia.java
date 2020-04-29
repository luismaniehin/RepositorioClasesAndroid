package com.ricopollo.lnieto.climaapp.Entities;

public class Lluvia {
    private String pcTiempo;
    private float pnCantidad;

    //Getters
    public String mxObtenerTiempo() { return this.pcTiempo; }
    public float mxObtenerCantidad() { return this.pnCantidad; }

    //Setters
    public void mxEstablecerTiempo(String tcTiempo) { this.pcTiempo = tcTiempo; }
    public void mxEstablecerCantidad(float tnCantidad) { this.pnCantidad = tnCantidad; }
}
