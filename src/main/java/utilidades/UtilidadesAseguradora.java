package utilidades;

import modelos.Aseguradora;
import modelos.EstadoPoliza;
import modelos.Poliza;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesAseguradora {
    public static Poliza recuperaPoliza(Aseguradora a, String numeroPoliza) {
        for (Poliza poliza : a.getListaPolizas()) {
            if (poliza.getNumero().equals(numeroPoliza)) {
                return poliza;
            }
        }
        return null;
    }

    public static List<Poliza> recuperaPolizasActivas(Aseguradora aseguradora) {
        List<Poliza> polizasActivas = new ArrayList<>();
        for (Poliza poliza : aseguradora.getListaPolizas()) {
            if (poliza.getEstadoPoliza().equals(EstadoPoliza.Vigente)) {
                polizasActivas.add(poliza);
            }
        }
        return polizasActivas;
    }

    public static List<Poliza> recuperaPolizasPorTomador(String nif, Aseguradora aseguradora) {
        List<Poliza> polizasPorTomador = new ArrayList<>();
        for (Poliza poliza : aseguradora.getListaPolizas()) {
            if (poliza.getTomador().getNif().equals(nif)) {
                polizasPorTomador.add(poliza);
            }
        }
        return polizasPorTomador;
    }



    public static List<Poliza> recuperaPolizasPorConductor(String nif, Aseguradora aseguradora) {
        List<Poliza> polizasPorConductor = new ArrayList<>();
        for (Poliza poliza : aseguradora.getListaPolizas()) {
            if (poliza.getConductorPrincipal().getNif().equals(nif)) {
                polizasPorConductor.add(poliza);
            }
        }
        return polizasPorConductor;
    }


}
