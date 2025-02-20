package modelos;

import utilidades.UtilidadesDireccion;
import utilidades.UtilidadesPersona;

import java.time.LocalDate;
import java.util.Objects;

import static utilidades.UtilidadesPersona.getEdad;

public class Persona {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private LocalDate fechaNacimiento;
    private Direccion direccion;
    private SexoFM sexo;
    private String paisOrigen;
    private String email;
    private String telefono;

    // CONSTRUCTORES

    public Persona(int i, String n, String ape1, String ape2, String nf, LocalDate fN, Direccion dir, SexoFM sx, String pa, String mail, String tel) {
        try {
            if (!UtilidadesPersona.esNIFValido(nf)) {
                throw new IllegalArgumentException("El nif no es valido");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación de la persona: " + e.getMessage());
        }

        id = i;
        nombre = n;
        apellido1 = ape1;
        apellido2 = ape2;
        nif = nf;
        fechaNacimiento = fN;
        direccion = dir;
        sexo = sx;
        paisOrigen = pa;
        email = mail;
        telefono = tel;
    }

    public Persona() {
        this.id = 0;
        this.nombre = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.nif = null;
        this.fechaNacimiento = null;
        this.direccion = new Direccion();
        this.sexo = null;
        this.paisOrigen = null;
        this.email = null;
        this.telefono = null;
    }
    public Persona(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellido1 = persona.getApellido1();
        this.apellido2 = persona.getApellido2();
        this.nif = persona.getNif();
        this.fechaNacimiento = persona.getFechaNacimiento();
        this.direccion = persona.getDireccion();
        this.sexo = persona.getSexo();
        this.paisOrigen = persona.getPaisOrigen();
        this.email = persona.getEmail();
        this.telefono = persona.getTelefono();
    }

    // GETTERS Y SETTERS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }

    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public SexoFM getSexo() { return sexo; }
    public void setSexo(SexoFM sexo) { this.sexo = sexo; }

    public String getPaisOrigen() { return paisOrigen; }
    public void setPaisOrigen(String PaisOrigen) { this.paisOrigen = PaisOrigen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // Métodos

    public String toString() {
        return "ID: " + getId() + ", NIF: " + getNif() + "\nNombre: " + getNombre() + " " + getApellido1() + " " + getApellido2() + "\nFecha de Nacimiento: "+ getFechaNacimiento() + "\nDireccion: " + getDireccion();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona oP = (Persona)o;
        return this.getId() == oP.getId() &&
                this.getNombre().equals(oP.getNombre())
                && this.getApellido1().equals(oP.getApellido1())
                && this.getApellido2().equals(oP.getApellido2());
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, apellido1, id);
    }


}
