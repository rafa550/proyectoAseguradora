package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class AnualidadPoliza {
    private int id;
    private String numero;
    private EstadoPoliza estadoPoliza;
    private String motivoAnulacion;
    private Cotizacion cotizacionBase;
    private ModoPago modoPago;
    private boolean esPagoFraccionado;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private double precioModalidad;
    private double precioFinal;
    private LocalDate fechaInicioAnualidad;
    private LocalDate fechaFinAnualidad;
    private LocalDate fechaAnulacion;
    private String monedaEuros;

    // CONSTRUCTORES
    public AnualidadPoliza(int id, String numero, EstadoPoliza estadoPoliza, String motivoAnulacion, Cotizacion cotizacionBase, ModoPago modoPago, boolean esPagoFraccionado, Persona tomador, Conductor conductorPrincipal, List<Conductor> conductoresOcasionales, double precioModalidad, double precioFinal, LocalDate fechaInicioAnualidad, LocalDate fechaFinAnualidad, LocalDate fechaAnulacion) {
        try {
            if (!numero.matches("^[A-Z]{3}/\\d{4}/\\d{6}$")) {
                throw new IllegalArgumentException("El número de póliza no es válido");
            }
            if (!cotizacionBase.getTomador().equals(tomador)) {
                throw new IllegalArgumentException("El tomador de la cotización no coincide con el tomador de la póliza");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El número de póliza no es válido");
        }
        this.id = id;
        this.numero = numero;
        this.estadoPoliza = estadoPoliza;
        this.motivoAnulacion = motivoAnulacion;
        this.cotizacionBase = cotizacionBase;
        this.modoPago = modoPago;
        this.esPagoFraccionado = esPagoFraccionado;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.precioModalidad = precioModalidad;
        if (esPagoFraccionado) {
            this.precioFinal = precioFinal * 1.05;
        } else {
            this.precioFinal = precioFinal;
        }
        this.fechaInicioAnualidad = fechaInicioAnualidad;
        this.fechaFinAnualidad = fechaFinAnualidad;
        this.fechaAnulacion = fechaAnulacion;
        if (esPagoFraccionado) {
            this.monedaEuros = " €";
        } else {
            this.precioFinal = precioFinal/3;
            this.monedaEuros = " €/mes";
        }

    }

    public AnualidadPoliza() {
        this.id = 0;
        this.numero = null;
        this.estadoPoliza = null;
        this.motivoAnulacion = null;
        this.cotizacionBase = null;
        this.modoPago = null;
        this.esPagoFraccionado = false;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = null;
        this.precioModalidad = 0;
        this.precioFinal = 0;
        this.fechaInicioAnualidad = null;
        this.fechaFinAnualidad = null;
        this.fechaAnulacion = null;
    }

    public AnualidadPoliza(AnualidadPoliza a) {
        this.id = a.getId();
        this.numero = a.getNumero();
        this.estadoPoliza = a.getEstadoPoliza();
        this.motivoAnulacion = a.getMotivoAnulacion();
        this.cotizacionBase = a.getCotizacionBase();
        this.modoPago = a.getModoPago();
        this.esPagoFraccionado = a.isEsPagoFraccionado();
        this.tomador = a.getTomador();
        this.conductorPrincipal = a.getConductorPrincipal();
        this.conductoresOcasionales = a.getConductoresOcasionales();
        this.precioModalidad = a.getPrecioModalidad();
        this.precioFinal = a.getPrecioFinal();
        this.fechaInicioAnualidad = a.getFechaInicioAnualidad();
        this.fechaFinAnualidad = a.getFechaFinAnualidad();
        this.fechaAnulacion = a.getFechaAnulacion();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public EstadoPoliza getEstadoPoliza() { return estadoPoliza; }
    public void setEstadoPoliza(EstadoPoliza estadoPoliza) { this.estadoPoliza = estadoPoliza; }

    public String getMotivoAnulacion() { return motivoAnulacion; }
    public void setMotivoAnulacion(String motivoAnulacion) { this.motivoAnulacion = motivoAnulacion; }

    public Cotizacion getCotizacionBase() { return cotizacionBase; }
    public void setCotizacionBase(Cotizacion cotizacionBase) { this.cotizacionBase = cotizacionBase; }

    public ModoPago getModoPago() { return modoPago; }
    public void setModoPago(ModoPago modoPago) { this.modoPago = modoPago; }

    public boolean isEsPagoFraccionado() { return esPagoFraccionado; }
    public void setEsPagoFraccionado(boolean esPagoFraccionado) { this.esPagoFraccionado = esPagoFraccionado; }

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
        AnualidadPoliza ap = (AnualidadPoliza) o;
        return getId() == ap.getId() && isEsPagoFraccionado() == ap.isEsPagoFraccionado() && Double.compare(ap.getPrecioModalidad(), getPrecioModalidad()) == 0 && Double.compare(ap.getPrecioFinal(), getPrecioFinal()) == 0 && Objects.equals(getNumero(), ap.getNumero()) && getEstadoPoliza() == ap.getEstadoPoliza() && Objects.equals(getMotivoAnulacion(), ap.getMotivoAnulacion()) && Objects.equals(getCotizacionBase(), ap.getCotizacionBase()) && getModoPago() == ap.getModoPago() && Objects.equals(getTomador(), ap.getTomador()) && Objects.equals(getConductorPrincipal(), ap.getConductorPrincipal()) && Objects.equals(getConductoresOcasionales(), ap.getConductoresOcasionales()) && Objects.equals(getFechaInicioAnualidad(), ap.getFechaInicioAnualidad()) && Objects.equals(getFechaFinAnualidad(), ap.getFechaFinAnualidad()) && Objects.equals(getFechaAnulacion(), ap.getFechaAnulacion());
    }

    public int hashCode() {
        return Objects.hash(id, numero, estadoPoliza, motivoAnulacion, cotizacionBase, modoPago, esPagoFraccionado, tomador, conductorPrincipal, conductoresOcasionales, precioModalidad, precioFinal, fechaInicioAnualidad, fechaFinAnualidad, fechaAnulacion);
    }

    public String toString() {
        return "Anualidad de la Póliza de número:" + numero +
                "\n\t Estado: " + estadoPoliza +
                "\n\t Cotización base: \t" + cotizacionBase +
                "\n\t Tomador:" + tomador +
                "\n\t Conductor principal=" + conductorPrincipal +
                "\n\t Conductores ocasionales=" + conductoresOcasionales +
                "\n\t Precio (según la modalidad)=" + precioModalidad + " €" +
                "\n\t Precio final: " + precioFinal + monedaEuros;
    }

    public int compareTo(AnualidadPoliza a) {
        return this.getFechaInicioAnualidad().compareTo(a.getFechaInicioAnualidad());
    }

}
