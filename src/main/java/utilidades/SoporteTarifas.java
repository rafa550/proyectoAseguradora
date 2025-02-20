package utilidades;

import com.aseguradora.utils.SoporteVehiculos;
import com.aseguradora.utils.Tarifa;
import modelos.Conductor;
import modelos.Cotizacion;
import modelos.Vehiculo;

public class SoporteTarifas {
    SoporteVehiculos soporteVehiculos = SoporteVehiculos.getInstance();
    UtilidadesPersona utilidadesPersona = new UtilidadesPersona();

    public Tarifa calcularTarifa(Cotizacion cotizacion) {
        Vehiculo vehiculo = cotizacion.getVehiculo();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        int edad = UtilidadesPersona.getEdad(cotizacion.getConductorPrincipal());

        Tarifa tarifa = soporteVehiculos.calcularTarifa(marca, modelo, edad);

        String cp = cotizacion.getConductorPrincipal().getDireccion().getCodigoPostal();
        double multiplicadorCP = soporteVehiculos.multiplicadorCP(cp);

        tarifa.setPrecioTERC(tarifa.getPrecioTERC() * multiplicadorCP);
        tarifa.setPrecioTAMP(tarifa.getPrecioTAMP() * multiplicadorCP);
        tarifa.setPrecioTRIE(tarifa.getPrecioTRIE() * multiplicadorCP);

        if (!cotizacion.isTieneAparcamientoPrivado()) {
            tarifa.setPrecioTERC(tarifa.getPrecioTERC() * 1.1);
            tarifa.setPrecioTAMP(tarifa.getPrecioTAMP() * 1.1);
            tarifa.setPrecioTRIE(tarifa.getPrecioTRIE() * 1.1);
        }
        if (UtilidadesPersona.getEdad(cotizacion.getConductorPrincipal()) < 25) {
            tarifa.setPrecioTERC(tarifa.getPrecioTERC() * 1.2);
            tarifa.setPrecioTAMP(tarifa.getPrecioTAMP() * 1.2);
            tarifa.setPrecioTRIE(tarifa.getPrecioTRIE() * 1.2);
        } else {
            for (Conductor conductor : cotizacion.getConductoresOcasionales()) {
                if (UtilidadesPersona.getEdad(conductor) < 25) {
                    tarifa.setPrecioTERC(tarifa.getPrecioTERC() * 1.05);
                    tarifa.setPrecioTAMP(tarifa.getPrecioTAMP() * 1.05);
                    tarifa.setPrecioTRIE(tarifa.getPrecioTRIE() * 1.05);
                    break;
                }
            }
        }

        int numSini5 = cotizacion.getNumSini5();
        tarifa.setPrecioTERC(tarifa.getPrecioTERC() * (1 + numSini5 * 0.1));
        tarifa.setPrecioTAMP(tarifa.getPrecioTAMP() * (1 + numSini5 * 0.1));
        tarifa.setPrecioTRIE(tarifa.getPrecioTRIE() * (1 + numSini5 * 0.1));

        return tarifa;
    }

}
