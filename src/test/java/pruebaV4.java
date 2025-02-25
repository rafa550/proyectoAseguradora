import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;
import com.aseguradora.utils.Tarifa;
import modelos.*;
import utilidades.SoporteTarifas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pruebaV4 {
    public static void main(String[] args) {
        Direccion direccion = new Direccion(1, TipoVia.Calle , "Madrid", 2, null, "28080" , "Madrid", new Provincia("Madrid", "28080"));
        Persona tomador = new Persona(1, "Juan", "Perez", "Gomez", "26898775E", LocalDate.of(1980, 1, 1), direccion, SexoFM.Masculino, "España", "juan.perez@example.com", "600123456");
        Conductor conductorPrincipal = new Conductor(2, "Ana", "Lopez", "Martinez", "60224602E", LocalDate.of(1995, 5, 15), direccion, SexoFM.Femenino, "España", "ana.lopez@example.com", "600654321", LocalDate.of(2013, 5, 15), 12, 5);

        List<Conductor> conductoresOcasionales = new ArrayList<>();
        conductoresOcasionales.add(conductorPrincipal);

        Modelo modelo = new Modelo("A3", 400.0F, 550.0F, 850.0F);
        Marca marca = new Marca("Audi", List.of(modelo));


        Vehiculo vehiculo = new Vehiculo(1, marca, modelo , "9697FKM", LocalDate.of(2015, 1, 1), "Rojo", tomador);
        Cotizacion cotizacion = new Cotizacion(1, 123, LocalDate.now(), LocalDate.of(2024, 1, 1), vehiculo, tomador, conductorPrincipal, conductoresOcasionales, true, 2, 1000.0, 1200.0, 1500.0, Modalidad.TERC);

        SoporteTarifas soporteTarifas = new SoporteTarifas();
        Tarifa tarifa = soporteTarifas.calcularTarifa(cotizacion);

        System.out.println("Tarifa TERC: " + tarifa.getPrecioTERC());
        System.out.println("Tarifa TAMP: " + tarifa.getPrecioTAMP());
        System.out.println("Tarifa TRIE: " + tarifa.getPrecioTRIE());
    }


}
