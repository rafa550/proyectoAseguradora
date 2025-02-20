package modelos;

import java.time.LocalDate;

public class Coche extends Vehiculo {
    private int numPuertas;
    private TipoCombust tipoCombustible;
    private Traccion traccion;
    private boolean esTodoTerreno;

    // CONSTRUCTORES

    public Coche() {
        super();
        this.numPuertas = 0;
        this.tipoCombustible = null;
        this.traccion = null;
        this.esTodoTerreno = false;
    }

    public Coche(int i, String mar, String mod, String mat, LocalDate fM, String col, Persona dA, int nP, TipoCombust tC, Traccion t, boolean eTT) {
        super(i,mar,mod,mat,fM,col,dA);
        numPuertas = nP;
        tipoCombustible = tC;
        traccion = t;
        esTodoTerreno = eTT;
    }

    public Coche(Coche c, int nP, TipoCombust tC, Traccion t, boolean eTT) {
        super(c);
        this.numPuertas = nP;
        this.tipoCombustible = tC;
        this.traccion = t;
        this.esTodoTerreno = eTT;

    }

    // GETTERS Y SETTERS

    public int getNumPuertas() {  return numPuertas;  }
    public void setNumPuertas(int numPuertas) { this.numPuertas = numPuertas; }

    public TipoCombust getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(TipoCombust tC) { this.tipoCombustible = tC; }

    public Traccion getTraccion() { return traccion; }
    public void setTraccion(Traccion tC) { this.traccion = tC; }

    public boolean getEsTodoTerreno() { return esTodoTerreno; }
    public void setEsTodoTerreno(boolean eTT) { this.esTodoTerreno = eTT; }

    // MÉTODOS
    public String toString() {
        return "Coche:\nID: " + getId() + ", Matricula: " + getMatricula() + "\nMarca: " + getMarca() + ", Modelo: " + getModelo();
    }
}
