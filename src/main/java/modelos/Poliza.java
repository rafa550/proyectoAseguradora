package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Poliza {
    private int id;
    private String numero;
    private List<AnualidadPoliza> anualidades;
    private EstadoPoliza estadoPoliza;
    private String motivoAnulacion;
    private Cotizacion ultimaCotizacionBase;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private double precioModalidad;
    private double precioFinal;
    private LocalDate fechaInicioAnualidad;
    private LocalDate fechaFinAnualidad;
    private LocalDate fechaAnulacion;

    // Constructor con parámetros
    public Poliza(int id, String numero, List<AnualidadPoliza> anualidades, EstadoPoliza estadoPoliza, String motivoAnulacion, Cotizacion ultimaCotizacionBase, Persona tomador, Conductor conductorPrincipal, List<Conductor> conductoresOcasionales, double precioModalidad, double precioFinal, LocalDate fechaInicioAnualidad, LocalDate fechaFinAnualidad, LocalDate fechaAnulacion) {
        try {
            if (!numero.matches("^[A-Z]{3}/\\d{4}/\\d{6}$")) {
                throw new IllegalArgumentException("El número de póliza no es válido");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error en la creación de la póliza: " + e.getMessage());
        }
        this.id = id;
        this.numero = numero;
        this.anualidades = anualidades;
        this.estadoPoliza = estadoPoliza;
        this.motivoAnulacion = motivoAnulacion;
        this.ultimaCotizacionBase = ultimaCotizacionBase;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.precioModalidad = precioModalidad;
        this.precioFinal = precioFinal;
        this.fechaInicioAnualidad = fechaInicioAnualidad;
        this.fechaFinAnualidad = fechaFinAnualidad;
        this.fechaAnulacion = fechaAnulacion;
    }

    public Poliza() {
        this.id = 0;
        this.numero = null;
        this.anualidades = null;
        this.estadoPoliza = null;
        this.motivoAnulacion = null;
        this.ultimaCotizacionBase = null;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = null;
        this.precioModalidad = 0;
        this.precioFinal = 0;
        this.fechaInicioAnualidad = null;
        this.fechaFinAnualidad = null;
        this.fechaAnulacion = null;
    }

    public Poliza(Poliza p) {
        this.id = p.getId();
        this.numero = p.getNumero();
        this.anualidades = p.getAnualidades();
        this.estadoPoliza = p.getEstadoPoliza();
        this.motivoAnulacion = p.getMotivoAnulacion();
        this.ultimaCotizacionBase = p.getUltimaCotizacionBase();
        this.tomador = p.getTomador();
        this.conductorPrincipal = p.getConductorPrincipal();
        this.conductoresOcasionales = p.getConductoresOcasionales();
        this.precioModalidad = p.getPrecioModalidad();
        this.precioFinal = p.getPrecioFinal();
        this.fechaInicioAnualidad = p.getFechaInicioAnualidad();
        this.fechaFinAnualidad = p.getFechaFinAnualidad();
        this.fechaAnulacion = p.getFechaAnulacion();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public List<AnualidadPoliza> getAnualidades() { return anualidades; }
    public void setAnualidades(List<AnualidadPoliza> anualidades) { this.anualidades = anualidades; }

    public EstadoPoliza getEstadoPoliza() { return estadoPoliza; }
    public void setEstadoPoliza(EstadoPoliza estadoPoliza) { this.estadoPoliza = estadoPoliza; }

    public String getMotivoAnulacion() { return motivoAnulacion; }
    public void setMotivoAnulacion(String motivoAnulacion) { this.motivoAnulacion = motivoAnulacion; }

    public Cotizacion getUltimaCotizacionBase() { return ultimaCotizacionBase; }
    public void setUltimaCotizacionBase(Cotizacion ultimaCotizacionBase) { this.ultimaCotizacionBase = ultimaCotizacionBase; }

    public Persona getTomador() { return tomador; }
    public void setTomador(Persona tomador) { this.tomador = tomador; }

    public Conductor getConductorPrincipal() { return conductorPrincipal; }
    public void setConductorPrincipal(Conductor conductorPrincipal) { this.conductorPrincipal = conductorPrincipal; }

    public List<Conductor> getConductoresOcasionales() { return conductoresOcasionales; }
    public void setConductoresOcasionales(List<Conductor> conductoresOcasionales) { this.conductoresOcasionales = conductoresOcasionales; }

    public double getPrecioModalidad() { return precioModalidad; }
    public void setPrecioModalidad(double precioModalidad) { this.precioModalidad = precioModalidad; }

    public double getPrecioFinal() { return precioFinal; }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

    public LocalDate getFechaInicioAnualidad() { return fechaInicioAnualidad; }
    public void setFechaInicioAnualidad(LocalDate fechaInicioAnualidad) { this.fechaInicioAnualidad = fechaInicioAnualidad; }

    public LocalDate getFechaFinAnualidad() { return fechaFinAnualidad; }
    public void setFechaFinAnualidad(LocalDate fechaFinAnualidad) { this.fechaFinAnualidad = fechaFinAnualidad; }

    public LocalDate getFechaAnulacion() { return fechaAnulacion; }
    public void setFechaAnulacion(LocalDate fechaAnulacion) { this.fechaAnulacion = fechaAnulacion; }

    // MÉTODOS

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poliza p = (Poliza) o;
        return getId() == p.getId() && Double.compare(p.getPrecioModalidad(), getPrecioModalidad()) == 0 && Double.compare(p.getPrecioFinal(), getPrecioFinal()) == 0 && Objects.equals(getNumero(), p.getNumero()) && Objects.equals(getAnualidades(), p.getAnualidades()) && getEstadoPoliza() == p.getEstadoPoliza() && Objects.equals(getMotivoAnulacion(), p.getMotivoAnulacion()) && Objects.equals(getUltimaCotizacionBase(), p.getUltimaCotizacionBase()) && Objects.equals(getTomador(), p.getTomador()) && Objects.equals(getConductorPrincipal(), p.getConductorPrincipal()) && Objects.equals(getConductoresOcasionales(), p.getConductoresOcasionales()) && Objects.equals(getFechaInicioAnualidad(), p.getFechaInicioAnualidad()) && Objects.equals(getFechaFinAnualidad(), p.getFechaFinAnualidad()) && Objects.equals(getFechaAnulacion(), p.getFechaAnulacion());
    }

    public int hashCode() {
        return Objects.hash(id, numero, anualidades, estadoPoliza, motivoAnulacion, ultimaCotizacionBase, tomador, conductorPrincipal, conductoresOcasionales, precioModalidad, precioFinal, fechaInicioAnualidad, fechaFinAnualidad, fechaAnulacion);
    }

    public String toString() {
        return "Poliza{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", anualidades=" + anualidades +
                ", estadoPoliza=" + estadoPoliza +
                ", motivoAnulacion='" + motivoAnulacion + '\'' +
                ", ultimaCotizacionBase=" + ultimaCotizacionBase +
                ", tomador=" + tomador +
                ", conductorPrincipal=" + conductorPrincipal +
                ", conductoresOcasionales=" + conductoresOcasionales +
                ", precioModalidad=" + precioModalidad +
                ", precioFinal=" + precioFinal +
                ", fechaInicioAnualidad=" + fechaInicioAnualidad +
                ", fechaFinAnualidad=" + fechaFinAnualidad +
                ", fechaAnulacion=" + fechaAnulacion +
                '}';
    }


}
