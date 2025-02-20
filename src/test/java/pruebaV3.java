import com.aseguradora.utils.Tarifa;
import modelos.*;
import utilidades.UtilidadesDireccion;

import java.time.LocalDate;

public class pruebaV3 {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.of(2005, 6, 28);
        Provincia p = new Provincia("Sevilla", "41440");
        Direccion d1 = new Direccion(1, TipoVia.Calle, "Blas Infante",  7, null, "41440", "Lora del Río", p);

        Persona pers = new Persona(1, "Rafa", "Tirado", "Heras","54256140Z", fecha, d1, SexoFM.Masculino, "España", "rafalintirado50@gmail.com", "666666666");

        System.out.println(pers);

        Vehiculo v1 = new Vehiculo(1, "Toyota", "Corolla", "5555NNN", LocalDate.of(2016, 5, 30), "Gris", pers);
        Vehiculo v2 = new Vehiculo(2, "Honda", "Off-Road", "1111ZZZ", LocalDate.of(2018, 2, 5), "Azul", pers);
        Vehiculo v3 = new Vehiculo(3, "Renault", "Clio", "2222BBB", LocalDate.of(2019, 3, 15), "Rojo", pers);

        System.out.println(v1); System.out.println(v2); System.out.println(v3);

        Coche c1 = new Coche(1, "Toyota", "Corolla", "5555NNN", LocalDate.of(2016, 5, 30), "Gris", pers, 4, TipoCombust.Gasolina, Traccion.Integral, false);
        Coche c2 = new Coche(2, "Renault", "Clio", "2222BBB", LocalDate.of(2019, 3, 15), "Rojo", pers, 4, TipoCombust.Gasolina, Traccion.Delantera, false);

        System.out.println(c1); System.out.println(c2);

        Moto m1 = new Moto(1, "Honda", "Off-Road", "1111ZZZ", LocalDate.of(2018, 2, 5), "Azul", pers, 5, false);
        Moto m2 = new Moto(2, "Yamaha", "R1", "3333CCC", LocalDate.of(2020, 1, 1), "Amarillo", pers, 5, false);

        System.out.println(m1); System.out.println(m2);

        Conductor con1 = new Conductor(1, "Pepe", "Lopez", "Dantas", "81626373V", LocalDate.of(2005,1,31), d1 ,SexoFM.Masculino, "España", "añsdfjñ@gmail.com", "622222222", LocalDate.of(2024, 8, 20), 0, 6 );

        System.out.println(con1);





    }
}
