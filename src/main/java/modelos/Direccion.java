package modelos;

import utilidades.UtilidadesDireccion;

import java.util.Objects;

public class Direccion {
    private int id;
    private TipoVia tipoVia;
    private String nombreVia;
    private int numero;
    private String restoDireccion;
    private String codigoPostal;
    private String localidad;
    private Provincia provincia;

    // CONSTRUCTORES (con parametros, sin y copia)

    public Direccion(int i, TipoVia tV, String nV, int n, String rD, String cP, String l, Provincia p) {
        try {
            if (!UtilidadesDireccion.esCPValido(cP)) {
                throw new IllegalArgumentException("El código postal no es valido");
            }
            if (!UtilidadesDireccion.compruebaCodProvincia(p.getCodigo(), p.getNombre()) || (p.getCodigo().length() != 5)) {
                throw new IllegalArgumentException("La concordancia provincia-codigo no es valida");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación de la dirección: " + e.getMessage());
        }

        id = i;
        tipoVia = tV;
        nombreVia = nV;
        numero = n;
        restoDireccion = rD;
        codigoPostal = cP;
        localidad = l;
        provincia = p;
    }
    public Direccion() {
        id = 0;
        tipoVia = null;
        nombreVia = null;
        numero = 0;
        restoDireccion = null;
        codigoPostal = null;
        localidad = null;
        provincia = null;
    }
    public Direccion(Direccion d) {
        this.id = d.getId();
        this.tipoVia = d.getTipoVia();
        this.nombreVia = d.getNombreVia();
        this.numero = d.getNumero();
        this.restoDireccion = d.getRestoDireccion();
        this.codigoPostal = d.getCodigoPostal();
        this.localidad = d.getLocalidad();
        this.provincia = d.getProvincia();
    }

    // GETTERS Y SETTERS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoVia getTipoVia() { return tipoVia; }
    public void setTipoVia(TipoVia tV) { tipoVia = tV; }

    public String getNombreVia() { return nombreVia; }
    public void setNombreVia(String nV) { nombreVia = nV; }

    public int getNumero() { return numero; }
    public void setNumero(int n) { numero = n; }

    public String getRestoDireccion() { return restoDireccion; }
    public void setRestoDireccion(String rD) { restoDireccion = rD; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String cP) { codigoPostal = cP; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String l) { localidad = l; }

    public Provincia getProvincia() { return provincia; }
    public void setProvincia(Provincia p) { provincia = p; }

    // MÉTODOS

    public String toString() {
        return getTipoVia() + " " + getNombreVia() + ", " + getNumero() + " " + getRestoDireccion() + " " + getCodigoPostal() + " " + getLocalidad() + " " + getProvincia();
    }

    public boolean equals(Direccion d) {
        return getId() == d.getId()
                && getCodigoPostal().equals(d.getCodigoPostal())
                && getNombreVia().equals(d.getNombreVia())
                && getNumero() == d.getNumero();
    }
    public int hashCode() {
        return Objects.hash(id, codigoPostal, nombreVia, numero);
    }
}
