package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aseguradora {
    private int id;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private List<Vehiculo> vehiculosAsegurados;
    private List<Poliza> listaPolizas;

    // CONSTRUCTORES

    public Aseguradora(int i, String nom, Direccion dir, String tel, List<Vehiculo> vehAs) {
        id = i;
        nombre = nom;
        direccion = dir;
        telefono = tel;
        vehiculosAsegurados = vehAs;
    }

    public Aseguradora() {
        this.id = 0;
        this.nombre = "";
        this.direccion = new Direccion();
        this.telefono = "";
        this.vehiculosAsegurados = new ArrayList<Vehiculo>();
    }

    public Aseguradora(Aseguradora aseg) {
        this.id = aseg.getId();
        this.nombre = aseg.getNombre();
        this.direccion = aseg.getDireccion();
        this.telefono = aseg.getTelefono();
        this.vehiculosAsegurados = aseg.getVehiculos();

    }

    // GETTERS Y SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Vehiculo> getVehiculos() { return vehiculosAsegurados; }
    public void setVehiculosAsegurados(List<Vehiculo> vehiculosAsegurados) { this.vehiculosAsegurados = vehiculosAsegurados; }

    public List<Poliza> getListaPolizas() { return listaPolizas; }
    public void setListaPolizas(List<Poliza> listaPolizas) { this.listaPolizas = listaPolizas; }

    // MÉTODOS
    public void addPoliza(Poliza p) {
        if (listaPolizas == null) {
            listaPolizas = new ArrayList<Poliza>();
        }
        listaPolizas.add(p);
    }

    public void removePoliza(String num) {
        if (listaPolizas == null) {
            return;
        }
        for (Poliza p : listaPolizas) {
            if (p.getNumero() == num) {
                listaPolizas.remove(p);
                break;
            }
        }
    }

    public String toString() {
        return "Aseguradora " + getId() + ": " + getNombre() + "\n" + getDireccion() + "\n " + getTelefono() + "\n" + getVehiculos();
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aseguradora that = (Aseguradora) o;
        return getId() == that.getId() && Objects.equals(getNombre(), that.getNombre()) && Objects.equals(getDireccion(), that.getDireccion()) && Objects.equals(getTelefono(), that.getTelefono());
    }

    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getDireccion(), getTelefono());
    }
}
