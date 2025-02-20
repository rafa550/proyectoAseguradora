import modelos.*;
import utilidades.UtilidadesPersona;
import utilidades.UtilidadesVehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pruebaV2 {
    public static void main(String[] args) {
        // PRUEBAS UTILIDADES

        LocalDate fecha = LocalDate.of(2005, 6, 28);
        Provincia p = new Provincia("Sevilla", "41440");
        Direccion d2 = new Direccion(1, TipoVia.Calle, "Blas Infante",  7, null, "41440", "Lora del Río", p);
        Persona p2 = new Persona(1, "Rafa", "Tirado", "Heras","55555555Z", fecha, d2, SexoFM.Masculino, "España", "rafalintirado50@gmail.com", "666666666");
        Vehiculo v2 = new Vehiculo(0, "Toyota", "Off-Road", "0000ZXY", LocalDate.of(2016, 2, 3), "Azul", p2);

        String nifprueba = "X9860293D";
        System.out.println(UtilidadesPersona.esNIFValido(nifprueba));
        System.out.println(UtilidadesPersona.esNIFValido(p2.getNif()));

        System.out.println(UtilidadesPersona.getEdad(p2));
        System.out.println(UtilidadesPersona.esMenor25(p2));
        System.out.println(UtilidadesVehiculo.calculaEdad(v2));

        // PRUEBAS CLASES
        Vehiculo v0 = new Vehiculo(); Vehiculo v3 = new Vehiculo(); Vehiculo v4 = new Vehiculo();
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(v0); listaVehiculos.add(v3); listaVehiculos.add(v4);
        Aseguradora aseg = new Aseguradora(0, "Aseguradora SafaReyes", d2, "955555555", listaVehiculos);
        System.out.println(aseg);
    }
}
