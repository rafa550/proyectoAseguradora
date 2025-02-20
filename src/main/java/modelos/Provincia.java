package modelos;

import utilidades.UtilidadesDireccion;

import java.util.Objects;

public class Provincia {
    private String nombre;
    private String codigo;

    // CONSTRUCTORES

    public Provincia(String nom, String cod) {
        this.nombre = nom;
        this.codigo = cod;
    }

    public Provincia() {
        this.nombre = null;
        this.codigo = null;
    }

    public Provincia(Provincia p) {
        this.nombre = p.getNombre();
        this.codigo = p.getCodigo();
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // MÉTODOS

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return getCodigo().equals(provincia.getCodigo());
    }

    public int hashCode() {
        return Objects.hashCode(getCodigo());
    }

    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
