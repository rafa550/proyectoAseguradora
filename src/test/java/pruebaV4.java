import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Tarifa;
import modelos.*;
import utilidades.SoporteTarifas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pruebaV4 {
    public static void main(String[] args) {
        // Create instances of the required classes
        Direccion direccion = new Direccion(1, TipoVia.Calle , "Madrid", 2, null, "28080" , "Madrid", new Provincia("Madrid", "28"));
        Persona tomador = new Persona(1, "Juan", "Perez", "Gomez", "12345678A", LocalDate.of(1980, 1, 1), direccion, SexoFM.Masculino, "España", "juan.perez@example.com", "600123456");
        Conductor conductorPrincipal = new Conductor();
        conductorPrincipal.setId(2);
        conductorPrincipal.setNombre("Ana");
        conductorPrincipal.setApellido1("Lopez");
        conductorPrincipal.setApellido2("Martinez");
        conductorPrincipal.setNif("87654321B");
        conductorPrincipal.setFechaNacimiento(LocalDate.of(1995, 5, 15));
        conductorPrincipal.setDireccion(direccion);
        conductorPrincipal.setSexo(SexoFM.Femenino);
        conductorPrincipal.setPaisOrigen("España");
        conductorPrincipal.setEmail("ana.lopez@example.com");
        conductorPrincipal.setTelefono("600654321");

        List<Conductor> conductoresOcasionales = new ArrayList<>();
        conductoresOcasionales.add(conductorPrincipal);

        // Crea marca y modelos validos a partir de sus clases
        Marca marca = new Marca("Toyota", );


        Vehiculo vehiculo = new Vehiculo(1, "Toyota", new Marca(""), , "1234ABC", LocalDate.of(2015, 1, 1), "Rojo", tomador);
        Cotizacion cotizacion = new Cotizacion(1, 123, LocalDate.now(), LocalDate.of(2024, 1, 1), vehiculo, tomador, conductorPrincipal, conductoresOcasionales, true, 2, 1000.0, 1200.0, 1500.0, Modalidad.TERCEROS);

        // Create an instance of SoporteTarifas and calculate the tariff
        SoporteTarifas soporteTarifas = new SoporteTarifas();
        Tarifa tarifa = soporteTarifas.calcularTarifa(cotizacion);

        // Print the results
        System.out.println("Tarifa TERC: " + tarifa.getPrecioTERC());
        System.out.println("Tarifa TAMP: " + tarifa.getPrecioTAMP());
        System.out.println("Tarifa TRIE: " + tarifa.getPrecioTRIE());
    }


}
