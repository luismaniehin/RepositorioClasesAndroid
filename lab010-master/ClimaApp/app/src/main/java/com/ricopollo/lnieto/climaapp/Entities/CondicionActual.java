package com.ricopollo.lnieto.climaapp.Entities;

public class CondicionActual {
    private int pnIDClima;
    private String pcCondicion;
    private String pcDescripcion;
    private String pcIcono;
    private float pnPresion;
    private float pnHumedad;

    //Getters
    public int mxObtenerIDClima() { return this.pnIDClima; }
    public String mxObtenerCondicion() { return this.pcCondicion; }
    public String mxObtenerDescripcion() { return this.pcDescripcion; }
    public String mxObtenerIcono() { return this.pcIcono; }
    public float mxObtenerPresion() { return this.pnPresion; }
    public float mxObtenerHumedad() { return this.pnHumedad; }

    //Setters
    public void mxEstablecerIDClima(int tnIDClima) { this.pnIDClima = tnIDClima; }
    public void mxEstablecerCondicion(String tcCondicion) { this.pcCondicion = tcCondicion; }
    public void mxEstablecerDescripcion(String tcDescripcion) { this.pcDescripcion = tcDescripcion; }
    public void mxEstablecerIcono(String tcIcono) { this.pcIcono = tcIcono; }
    public void mxEstablecerPresion(float tnPresion) { this.pnPresion = tnPresion; }
    public void mxEstablecerHumedad(float tnHumedad) { this.pnHumedad = tnHumedad; }

}
