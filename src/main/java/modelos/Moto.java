package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Moto extends Vehiculo {
    private int cilindradaCC;
    private boolean tieneSidecar;

    // CONSTRUCTORES

    public Moto() {
        super();
        cilindradaCC = 0;
        tieneSidecar = false;
    }

    public Moto(int i, String mar, String mod, String mat, LocalDate fM, String col, Persona dA, int cCC, boolean tS) {
        super(i, mar, mod, mat, fM, col, dA);
        cilindradaCC = cCC;
        tieneSidecar = tS;
    }

    public Moto(Moto m) {
        super(m);
        cilindradaCC = m.getCilindrada();
        tieneSidecar = m.getTieneSidecar();
    }

    // GETTERS Y SETTERS
    public int getCilindrada() { return cilindradaCC; }
    public void setCilindrada(int cilindrada) { this.cilindradaCC = cilindrada; }

    public boolean getTieneSidecar() { return tieneSidecar; }
    public void setTieneSidecar(boolean tS) { this.tieneSidecar = tS; }

    // MÉTODOS
    public String toString() {
        return "Moto:\nID: " + getId() + "Matrícula: " + getMatricula()
                + "\nMarca: " + getMarca() + ", Modelo: " + getModelo();
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Moto moto = (Moto) o;
        return cilindradaCC == moto.getCilindrada() && getTieneSidecar() == moto.getTieneSidecar();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getCilindrada(), getTieneSidecar());
    }
}
