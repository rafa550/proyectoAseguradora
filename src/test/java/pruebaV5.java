import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import modelos.*;
import utilidades.UtilidadesAseguradora;
import modelos.TipoVia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pruebaV5 {
    public static void main(String[] args) {
        // Personas
        Direccion direccionTomador = new Direccion(1, TipoVia.Calle, "Falsa", 123, "", "28080", "Madrid", new Provincia("Madrid", "28080"));
        Direccion direccionConductor = new Direccion(2, TipoVia.Avenida, "Roda Arriba", 742, null, "41440", "Lora del Río", new Provincia("Sevilla", "41440"));

        Persona tomador = new Persona(1, "Juan", "Perez", "Gomez", "26898775E", LocalDate.of(1980, 5, 20), direccionTomador, SexoFM.Masculino, "España", "juan.perez@example.com", "600123456");
        Conductor conductorPrincipal = new Conductor(2, "Maria", "Lopez", "Martinez", "60224602E", LocalDate.of(1985, 8, 15), direccionConductor, SexoFM.Femenino, "USA", "maria.lopez@example.com", "600654321", LocalDate.of(2000, 5, 15), 12, 5);

        // Vehículo
        Modelo modelo = new Modelo("Corolla", 100, 250, 400 );
        Modelo modelo2 = new Modelo("Camry", 50, 150, 300 );
        Modelo modelo3 = new Modelo("Prius", 200, 300, 500 );
        List<Modelo> modelos = new ArrayList<>(); modelos.add(modelo); modelos.add(modelo2); modelos.add(modelo3);
        Marca marca = new Marca("Toyota", modelos);

        Vehiculo vehiculo = new Vehiculo(1, marca, modelo , "9697FKM", LocalDate.of(2015, 1, 1), "Rojo", tomador);

        // Conductores ocasionales
        Conductor conductorOcasional1 = new Conductor(3, "Carlos", "Garcia", "Fernandez", "71873864Z", LocalDate.of(1990, 3, 10), direccionTomador, SexoFM.Masculino, "España", "carlos.garcia@example.com", "600789012", LocalDate.of(2010, 4, 20), 10, 5);
        Conductor conductorOcasional2 = new Conductor(4, "Laura", "Martinez", "Sanchez", "48437533Q", LocalDate.of(1992, 7, 25), direccionConductor, SexoFM.Femenino, "España", "laura.martinez@example.com", "600345678", LocalDate.of(2012, 6, 15), 8, 3);
        Conductor conductorOcasional3 = new Conductor(5, "Pedro", "Rodriguez", "Lopez", "24826078Q", LocalDate.of(1988, 12, 5), direccionTomador, SexoFM.Masculino, "España", "pedro.rodriguez@example.com", "600987654", LocalDate.of(2008, 1, 10), 12, 6);


        // Cotización
        Cotizacion cotizacionBase1 = new Cotizacion(1, 123, LocalDate.now(), LocalDate.of(2024, 1, 1), vehiculo, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2, conductorOcasional3), true, 2, 1000.0, 1200.0, 1500.0, Modalidad.TERC);
        Cotizacion cotizacionBase2 = new Cotizacion(2, 124, LocalDate.now(), LocalDate.of(2024, 1, 1), vehiculo, tomador, conductorPrincipal, List.of(conductorOcasional1), true, 2, 1100.0, 1300.0, 1600.0, Modalidad.TERC);
        Cotizacion cotizacionBase3 = new Cotizacion(3, 125, LocalDate.now(), LocalDate.of(2024, 1, 1), vehiculo, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2), true, 2, 1200.0, 1400.0, 1700.0, Modalidad.TERC);

        // Anualidades
        List<AnualidadPoliza> anualidadesPoliza1 = new ArrayList<>();
        anualidadesPoliza1.add(new AnualidadPoliza(1, "ABC/2023/000001", EstadoPoliza.Vigente, null, cotizacionBase1, ModoPago.Tarjeta, false, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2), 500.0, 600.0, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), null));
        anualidadesPoliza1.add(new AnualidadPoliza(2, "ABC/2024/000002", EstadoPoliza.Vigente, null, cotizacionBase2, ModoPago.Tarjeta, false, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2, conductorOcasional3), 520.0, 620.0, LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1), null));

        List<AnualidadPoliza> anualidadesPoliza2 = new ArrayList<>();
        anualidadesPoliza2.add(new AnualidadPoliza(1, "DEF/2023/000003", EstadoPoliza.Vigente, null, cotizacionBase3, ModoPago.IBAN, false, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2), 500.0, 600.0, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), null));

        List<AnualidadPoliza> anualidadesPoliza3 = new ArrayList<>();
        anualidadesPoliza3.add(new AnualidadPoliza(1, "GHI/2023/000004", EstadoPoliza.Vigente, null, cotizacionBase1, ModoPago.Tarjeta, false, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2, conductorOcasional3), 500.0, 600.0, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), null));
        anualidadesPoliza3.add(new AnualidadPoliza(2, "GHI/2024/000005", EstadoPoliza.Vigente, null, cotizacionBase2, ModoPago.Tarjeta, false, tomador, conductorPrincipal, List.of(conductorOcasional1), 530.0, 630.0, LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1), null));
        anualidadesPoliza3.add(new AnualidadPoliza(3, "GHI/2025/000006", EstadoPoliza.Vigente, null, cotizacionBase3, ModoPago.Tarjeta, false, tomador, conductorPrincipal, List.of(conductorOcasional1, conductorOcasional2), 550.0, 650.0, LocalDate.of(2025, 1, 1), LocalDate.of(2026, 1, 1), null));

        // Pólizas
        Poliza poliza1 = new Poliza(1, "ABC/2023/000001", anualidadesPoliza1, EstadoPoliza.Vigente, null, null, tomador, conductorPrincipal, null, 500.0, 600.0, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), null);
        Poliza poliza2 = new Poliza(2, "ABC/2023/000002", anualidadesPoliza2, EstadoPoliza.Anulada, "No pago", null, tomador, conductorPrincipal, null, 500.0, 600.0, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), LocalDate.of(2023, 6, 1));
        Poliza poliza3 = new Poliza(3, "ABC/2023/000003", anualidadesPoliza3, EstadoPoliza.Vigente, null, null, tomador, conductorPrincipal, null, 500.0, 600.0, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), null);

        List<Poliza> listaPolizas = new ArrayList<>();
        listaPolizas.add(poliza1);
        listaPolizas.add(poliza2);
        listaPolizas.add(poliza3);

        Aseguradora aseguradora = new Aseguradora();
        aseguradora.setListaPolizas(listaPolizas);


        // Imprimir por pantalla funcionalidad con datos
        System.out.println("----Prueba recuperaPoliza----");
        Poliza polizaRecuperada = UtilidadesAseguradora.recuperaPoliza(aseguradora, "ABC/2023/000001");
        if (polizaRecuperada != null) {
            System.out.println("\t" + polizaRecuperada);
        } else {
            System.out.println("No encontrada");
        }

        System.out.println("\n----Prueba recuperaPolizasActivas----");
        List<Poliza> polizasActivas = UtilidadesAseguradora.recuperaPolizasActivas(aseguradora);
        for (Poliza p : polizasActivas) {
            System.out.println("\n" + p.toString());
        }

        System.out.println("\n----Prueba recuperaPolizasPorTomador----");
        List<Poliza> polizasPorTomador = UtilidadesAseguradora.recuperaPolizasPorTomador("26898775E", aseguradora);
        for (Poliza p : polizasPorTomador) {
            System.out.println("\n" + p.toString());
        }

        System.out.println("\n----Prueba recuperaPolizasPorConductor----");
        List<Poliza> polizasPorConductor = UtilidadesAseguradora.recuperaPolizasPorConductor("60224602E", aseguradora);
        if (polizasPorConductor.isEmpty()) {
            System.out.println("Error recuperando la Poliza por DNI");
        } else {
            for (Poliza p : polizasPorConductor) {
                System.out.println("\n" + p.toString()) ;
            }
        }

    }
}
