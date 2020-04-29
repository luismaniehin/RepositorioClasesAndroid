package com.ricopollo.lnieto.climaapp.Entities;

public class Viento {
    private float pnVelocidad;
    private float pnGrado;

    //Getters
    public float mxObtenerVelocidad() { return this.pnVelocidad; }
    public float mxObtenerGrado() { return this.pnGrado; }

    //Setters
    public void mxEstablecerVelocidad(float tnVelocidad) { this.pnVelocidad = tnVelocidad; }
    public void mxEstablecerGrado(float tnGrado) { this.pnGrado = tnGrado; }
}
