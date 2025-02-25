package modelos;

import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;
import utilidades.UtilidadesVehiculo;

import java.time.LocalDate;
import java.util.Objects;

public class Vehiculo {
    private int id;
    private String marca;
    private Marca marc;
    private String modelo;
    private Modelo model;
    private String matricula;
    private LocalDate fechaMatriculacion;
    private String color;
    private Persona duenyoActual;

    // CONSTRUCTORES
    // Con marca y modelo como string

    public Vehiculo(int i, String mar, String mod, String mat, LocalDate f, String c, Persona p) {
        try {
            if (!SoporteVehiculos.getInstance().esMarcaValida(mar)) {
                throw new IllegalArgumentException("Marca invalida");
            }
            if (!SoporteVehiculos.getInstance().esModeloValido(mar, mod)) {
                throw new IllegalArgumentException("Modelo invalido");
            }
            if (!UtilidadesVehiculo.validaFechaMatriculacion(f)) {
                throw new IllegalArgumentException("Fecha matriculacion invalida");
            }
            if (!UtilidadesVehiculo.esMatriculaValida(mat)) {
                throw new IllegalArgumentException("Matricula invalida");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación del vehículo: " + e.getMessage());
        }
        id = i;
        marca = mar;
        modelo = mod;
        matricula = mat;
        fechaMatriculacion = f;
        color = c;
        duenyoActual = p;
    }

    // Con marca y modelo como objetos Marca y Modelo
    public Vehiculo(int i, Marca marca, Modelo mod, String mat, LocalDate f, String c, Persona p) {
        try {
            if (SoporteVehiculos.getInstance().esMarcaValida(marca.getNombre()) != true) {
                throw new IllegalArgumentException("Marca invalida");
            }
            if (SoporteVehiculos.getInstance().esModeloValido(marca.getNombre(), mod.getNombre()) != true) {
                throw new IllegalArgumentException("Modelo invalido");
            }
            if (UtilidadesVehiculo.validaFechaMatriculacion(f) != true) {
                throw new IllegalArgumentException("Fecha matriculacion invalida");
            }
            if (UtilidadesVehiculo.esMatriculaValida(mat) != true) {
                throw new IllegalArgumentException("Matricula invalida");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación del vehículo: " + e.getMessage());
        }

        id = i;
        marc = marca;
        model = mod;
        matricula = mat;
        fechaMatriculacion = f;
        color = c;
        duenyoActual = p;
    }

    public Vehiculo() {
        this.id = 0;
        this.marca = null;
        this.modelo = null;
        this.matricula = null;
        this.fechaMatriculacion = null;
        this.color = null;
        this.duenyoActual = null;
    }

    public Vehiculo(Vehiculo v) {
        this.id = v.getId();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.matricula = v.getMatricula();
        this.fechaMatriculacion = v.getFechaMatriculacion();
        this.color = v.getColor();
        this.duenyoActual = v.getDuenyoActual();
    }

    // GETTERS Y SETTERS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public LocalDate getFechaMatriculacion() { return fechaMatriculacion; }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) { this.fechaMatriculacion = fechaMatriculacion; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Persona getDuenyoActual() { return duenyoActual; }
    public void setDuenyoActual(Persona p) { this.duenyoActual = p; }

    // MÉTODOS

    public String toString() {
        return "Vehiculo:\nID:" + getId() + ", Matrícula: " + getMatricula()
                + "\nMarca: " + getMarca() + ", Modelo: " + getModelo();
    }

    public boolean equals(Vehiculo v) {
        return id == v.getId() &&
                getMatricula().equals(v.getMatricula());
    }

    public int hashCode() {
        return Objects.hash(id, matricula);
    }

}
