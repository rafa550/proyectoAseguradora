package modelos;

import utilidades.UtilidadesPersona;
import utilidades.UtilidadesVehiculo;

import java.time.LocalDate;
import java.util.Objects;

import static utilidades.UtilidadesPersona.getEdad;

public class Conductor extends Persona{
    private LocalDate fechaCarnet;
    private int puntosCarnet;
    private int anyosAsegurados;

    // CONSTRUCTORES

    public Conductor(int id, String nombre, String ape1, String ape2, String nf, LocalDate fecna, Direccion d, SexoFM sx, String pO, String mail, String tel, LocalDate fC, int pC, int aA) {
        super(id, nombre, ape1, ape2, nf, fecna, d, sx, pO, mail, tel);
        try {
            if (UtilidadesPersona.esMayorEdad(getEdad(fecna)) == false) {
                throw new IllegalArgumentException("El conductor no es mayor de edad");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación del conductor: " + e.getMessage());
        }
        fechaCarnet = fC;
        puntosCarnet = pC;
        anyosAsegurados = aA;
    }

    public Conductor() {
        super();
        this.fechaCarnet = null;
        this.puntosCarnet = 0;
        this.anyosAsegurados = 0;
    }

    public Conductor(Conductor C) {
        super(C);
        this.fechaCarnet = C.getFechaCarnet();
        this.puntosCarnet = C.getPuntosCarnet();
        this.anyosAsegurados = C.getAnyosAsegurados();
    }

    // GETTERS Y SETTERS
    public LocalDate getFechaCarnet() { return fechaCarnet; }
    public void setFechaCarnet(LocalDate fechaCarnet) { this.fechaCarnet = fechaCarnet; }

    public int getPuntosCarnet() { return puntosCarnet; }
    public void setPuntosCarnet(int puntosCarnet) { this.puntosCarnet = puntosCarnet; }

    public int getAnyosAsegurados() { return anyosAsegurados; }
    public void setAnyosAsegurados(int anyosAsegurados) { this.anyosAsegurados = anyosAsegurados; }

    // MÉTODOS

    public String toString() {
        return super.toString() + "\nFecha carnet:" + fechaCarnet +
                ", puntosCarnet=" + puntosCarnet +
                ", anyosAsegurados=" + anyosAsegurados;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Conductor conductor = (Conductor) o;
        return getPuntosCarnet() == conductor.getPuntosCarnet() && getAnyosAsegurados() == conductor.getAnyosAsegurados() && Objects.equals(getFechaCarnet(), conductor.getFechaCarnet());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getFechaCarnet(), getPuntosCarnet(), getAnyosAsegurados());
    }
}
