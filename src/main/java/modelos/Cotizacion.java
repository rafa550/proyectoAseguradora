package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Cotizacion {
    private int id;
    private int codigo;
    private LocalDate fechaCotizacion;
    private LocalDate fechaInicio;
    private Vehiculo vehiculo;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private boolean tieneAparcamientoPrivado;
    private int numSini5;
    private double precioTERC;
    private double precioTAMP;
    private double precioTRIE;
    private Modalidad modalidadElegida;

    // CONSTRUCTORES
    public Cotizacion(int id, int codigo, LocalDate fechaCotizacion, LocalDate fechaInicio, Vehiculo vehiculo, Persona tomador, Conductor conductorPrincipal, List<Conductor> conductoresOcasionales, boolean tieneAparcamientoPrivado, int numSini5, double precioTERC, double precioTAMP, double precioTRIE, Modalidad modalidadElegida) {
        this.id = id;
        this.codigo = codigo;
        this.fechaCotizacion = fechaCotizacion;
        this.fechaInicio = fechaInicio;
        this.vehiculo = vehiculo;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.tieneAparcamientoPrivado = tieneAparcamientoPrivado;
        this.numSini5 = numSini5;
        this.precioTERC = precioTERC;
        this.precioTAMP = precioTAMP;
        this.precioTRIE = precioTRIE;
        this.modalidadElegida = modalidadElegida;
    }

    public Cotizacion() {
        this.id = 0;
        this.codigo = 0;
        this.fechaCotizacion = null;
        this.fechaInicio = null;
        this.vehiculo = null;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = null;
        this.tieneAparcamientoPrivado = false;
        this.numSini5 = 0;
        this.precioTERC = 0;
        this.precioTAMP = 0;
        this.precioTRIE = 0;
        this.modalidadElegida = null;
    }

    public Cotizacion(Cotizacion c) {
        this.id = c.getId();
        this.codigo = c.getCodigo();
        this.fechaCotizacion = c.getFechaCotizacion();
        this.fechaInicio = c.getFechaInicio();
        this.vehiculo = c.getVehiculo();
        this.tomador = c.getTomador();
        this.conductorPrincipal = c.getConductorPrincipal();
        this.conductoresOcasionales = c.getConductoresOcasionales();
        this.tieneAparcamientoPrivado = c.isTieneAparcamientoPrivado();
        this.numSini5 = c.getNumSini5();
        this.precioTERC = c.getPrecioTERC();
        this.precioTAMP = c.getPrecioTAMP();
        this.precioTRIE = c.getPrecioTRIE();
        this.modalidadElegida = c.getModalidadElegida();
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public LocalDate getFechaCotizacion() { return fechaCotizacion; }
    public void setFechaCotizacion(LocalDate fechaCotizacion) { this.fechaCotizacion = fechaCotizacion; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public Persona getTomador() { return tomador; }
    public void setTomador(Persona tomador) { this.tomador = tomador; }

    public Conductor getConductorPrincipal() { return conductorPrincipal; }
    public void setConductorPrincipal(Conductor conductorPrincipal) { this.conductorPrincipal = conductorPrincipal; }

    public List<Conductor> getConductoresOcasionales() { return conductoresOcasionales; }
    public void setConductoresOcasionales(List<Conductor> conductoresOcasionales) { this.conductoresOcasionales = conductoresOcasionales; }

    public boolean isTieneAparcamientoPrivado() { return tieneAparcamientoPrivado; }
    public void setTieneAparcamientoPrivado(boolean tieneAparcamientoPrivado) { this.tieneAparcamientoPrivado = tieneAparcamientoPrivado; }

    public int getNumSini5() { return numSini5; }
    public void setNumSini5(int numSini5) { this.numSini5 = numSini5; }

    public double getPrecioTERC() { return precioTERC; }
    public void setPrecioTERC(double precioTERC) { this.precioTERC = precioTERC; }

    public double getPrecioTAMP() { return precioTAMP; }
    public void setPrecioTAMP(double precioTAMP) { this.precioTAMP = precioTAMP; }

    public double getPrecioTRIE() { return precioTRIE; }
    public void setPrecioTRIE(double precioTRIE) { this.precioTRIE = precioTRIE; }

    public Modalidad getModalidadElegida() { return modalidadElegida; }
    public void setModalidadElegida(Modalidad modalidadElegida) { this.modalidadElegida = modalidadElegida; }

    // MÉTODOS

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cotizacion cot = (Cotizacion) o;
        return getId() == cot.getId() && getCodigo() == cot.getCodigo() && isTieneAparcamientoPrivado() == cot.isTieneAparcamientoPrivado()
                && getNumSini5() == cot.getNumSini5() && Double.compare(cot.getPrecioTERC(), getPrecioTERC()) == 0
                && Double.compare(cot.getPrecioTAMP(), getPrecioTAMP()) == 0 && Double.compare(cot.getPrecioTRIE(), getPrecioTRIE()) == 0
                && Objects.equals(getFechaCotizacion(), cot.getFechaCotizacion()) && Objects.equals(getFechaInicio(), cot.getFechaInicio())
                && Objects.equals(getVehiculo(), cot.getVehiculo()) && Objects.equals(getTomador(), cot.getTomador())
                && Objects.equals(getConductorPrincipal(), cot.getConductorPrincipal()) && Objects.equals(getConductoresOcasionales(), cot.getConductoresOcasionales())
                && getModalidadElegida() == cot.getModalidadElegida();
    }

    public int hashCode() {
        return Objects.hash(id, codigo, fechaCotizacion, fechaInicio, vehiculo, tomador, conductorPrincipal, conductoresOcasionales, tieneAparcamientoPrivado, numSini5, precioTERC, precioTAMP, precioTRIE, modalidadElegida);
    }

    public String toString() {
        return "Cotización: codigo " + codigo +
                "\n\t Fecha de la cotización: " + fechaCotizacion +
                "\n\t Fecha de inicio: " + fechaInicio +
                "\n\t Vehículo: " + vehiculo +
                "\n\t Tomador: " + tomador +
                "\n\t Conductor Principal: " + conductorPrincipal;
    }


}